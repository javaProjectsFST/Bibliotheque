
package model.entities;

public class Employe {
    private String Mdp;
    private String Login;
    private String Prenom;
    private String Nom;
    private String Email;
    private boolean Ger;
    
    public Employe(){
        
    }

    public Employe(String Mdp, String Login, String Prenom, String Nom, String Email, boolean Ger) {
        this.Mdp = Mdp;
        this.Login = Login;
        this.Prenom = Prenom;
        this.Nom = Nom;
        this.Email=Email;
        this.Ger = Ger;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
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

    public boolean isGer() {
        return Ger;
    }

    public void setGer(boolean Ger) {
        this.Ger = Ger;
    }
}