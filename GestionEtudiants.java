import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class GestionEtudiants {
    private List<Etudiant> etudiants = new ArrayList<>();

    public void importerDonnees(String cheminFichier) {
        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            br.readLine(); // Ignorer l'en-tête

            while ((ligne = br.readLine()) != null) {
                String[] donnee = ligne.split(";");

                int matricule = Integer.parseInt(donnee[0].trim());
                String nom = donnee[1].trim();
                String cours = donnee[2].trim();
                double note = Double.parseDouble(donnee[3].trim());

                etudiants.add(new Etudiant(matricule, nom, cours, note));
            }
        }
        catch (IOException ex) {
            //ex.printStackTrace();
            System.out.println("Details d'erreur : " + ex.getMessage());
        }
    }

    public void afficher_etudiants() {
        System.out.println(etudiants);
    }

    /*double calculerMoyenneEtudiant (Etudiant e){
        return etudiants.stream()
                .filter(etudiant -> etudiant.getEtudiant().equals(e))
                .mapToDouble(note::getNote)
                .average()
                .orElse(0.0); // retourne 0.0 si pas de notes
    }*/
    public void calculer_moyenne() {
        Map<String, Double> moyennesParEtudiant = etudiants.stream()
                .collect(Collectors.groupingBy(
                        //Etudiant::getMatricule,
                        e -> e.getMatricule() + " - " + e.getNom(), // clé = matricule + nom
                        Collectors.averagingDouble(Etudiant::getNote)       // moyenne des notes
                ));
        moyennesParEtudiant.forEach((Matricule_Nom, Moyenne) ->
                System.out.printf("%s : %.2f%n", Matricule_Nom, Moyenne)
        );
    }

    public void classer_etudiants() {
        Map<String, Double> moyennesParEtudiant = etudiants.stream()
                .collect(Collectors.groupingBy(
                        //Etudiant::getMatricule,
                        e -> e.getMatricule() + " - " + e.getNom(),
                        Collectors.averagingDouble(Etudiant::getNote)
                ));
        moyennesParEtudiant.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed()) // tri par valeur décroissante
                .forEach(entry ->
                        System.out.printf("%s : %.2f%n", entry.getKey(), entry.getValue())
                );
    }

    public void sauvegarder_resultats(String cheminFichier) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(cheminFichier))) {
            writer.println("Matricule,Nom,Moyenne"); // Écrire l'en-tête du CSV

            Map<String, Double> moyennesParEtudiant = etudiants.stream()
                    .collect(Collectors.groupingBy(
                            //Etudiant::getMatricule,
                            e -> e.getMatricule() + "," + e.getNom(),
                            Collectors.averagingDouble(Etudiant::getNote)
                    ));

            moyennesParEtudiant.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .forEach(entry -> {
                        String[] parts = entry.getKey().split(",", 2); // 0=Matricule, 1=Nom
                        writer.printf("%s,%s,%.2f%n", parts[0], parts[1], entry.getValue());
                    });
            }
        catch (IOException ex) {
            System.out.println("Erreur de sauvegarde : " + ex.getMessage());
        }
    }

}
