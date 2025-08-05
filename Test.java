import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        GestionEtudiants gestion = new GestionEtudiants();

        // Importation des donnees
        gestion.importerDonnees("Notes_Etudiants.csv");

        // Variables pour suivre l'état
        boolean moyenneCalculee = false;
        boolean resultatClassement = false;

        // Menu de gestion
        while (true) {
            System.out.println("\n--------Menu de Getion de Notes des Etudiants------");
            System.out.println("1. Afficher la liste des etudiants");
            System.out.println("2. Calculer la moyenne de chaque etudiant");
            System.out.println("3. Classer les étudiants par moyenne");
            System.out.println("4. Sauvegarder les resultats dans un autre fichier");
            System.out.println("5. Quitter");
            System.out.println("Choisissez une option : ");

            Scanner scan = new Scanner(System.in);
            int option = scan.nextInt();
            switch (option) {
                case 1: {
                    gestion.afficher_etudiants();
                    break;
                }
                case 2: {
                    gestion.calculer_moyenne();
                    moyenneCalculee = true;
                    break;
                }
                case 3: {
                    if (!moyenneCalculee) {
                        System.out.println("Vous devez au préalable calculer les moyennes (option 2) !");
                    } else {
                        gestion.classer_etudiants();
                        resultatClassement = true;
                    }
                    break;
                }
                case 4: {
                    if (moyenneCalculee && resultatClassement) {
                        gestion.sauvegarder_resultats("Resultats.csv");
                        System.out.println("Les données ont été sauvegardées avec succès !");
                    } else {
                        System.out.println("Vous devez au préalable calculer les moyennes et les classer (option 2, puis 3) !");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Aurevoir!!!");
                    return;
                }
            }
        }
    }
}
