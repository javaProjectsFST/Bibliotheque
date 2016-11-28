
package model.entities;

public class Adherent {
    private String Mdp;
    private String Login;
    private String Prenom;
    private String Nom;
    private String Email;
    private int NumbEmprent;
    private int NumbReservation;
    
    public  Adherent(){
        
    }

    public Adherent(String Mdp, String Login, String Prenom, String Nom, String Email) {
        this.Mdp = Mdp;
        this.Login = Login;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Email = Email.toLowerCase();
        this.NumbEmprent=0;
        this.NumbReservation=0;
    }

    public String getMdp() {
        return Mdp;
    }

    public void setMdp(String Mdp) {
        this.Mdp = Mdp;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email.toLowerCase();
    }

    public int getNumbEmprent() {
        return NumbEmprent;
    }

    public void setNumbEmprent(int NumbEmprent) {
        this.NumbEmprent = NumbEmprent;
    }

    public int getNumbReservation() {
        return NumbReservation;
    }

    public void setNumbReservation(int NumbReservation) {
        this.NumbReservation = NumbReservation;
    }
}
