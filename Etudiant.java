public class Etudiant {
    private int Matricule;
    private String Nom;
    private String Cours;
    private double Note;

    public Etudiant(int Matricule, String Nom, String Cours, double Note){
        this.Matricule = Matricule;
        this.Nom = Nom;
        this.Cours = Cours;
        this.Note = Note;
    }

    public int getMatricule() {return Matricule;}
    public String getNom() {return Nom;}
    public String getCours() {return Cours;}
    public double getNote() {return Note;}

    @Override
    public String toString() {
        return Matricule + " - " + Nom + " - " + Cours + " - " + Note + "\n";
    }
}
