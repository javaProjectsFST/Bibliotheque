
package model;

import java.sql.Date;


public class Livre {
    private int LivreId;
    private String Titre;
    private String Auteur;
    private String Editeur;
    private Date DateEdition;

    public Livre(int LivreId, String Titre, String Auteur, String Editeur, Date DateEdition) {
        this.LivreId = LivreId;
        this.Titre = Titre;
        this.Auteur = Auteur;
        this.Editeur = Editeur;
        this.DateEdition = DateEdition;
    }
    
    public int getId() {
        return LivreId;
    }

    public void setId(int LivreId) {
        this.LivreId = LivreId;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String Auteur) {
        this.Auteur = Auteur;
    }

    public String getEditeur() {
        return Editeur;
    }

    public void setEditeur(String Editeur) {
        this.Editeur = Editeur;
    }

    public Date getDateEdition() {
        return DateEdition;
    }

    public void setDateEdition(Date DateEdition) {
        this.DateEdition = DateEdition;
    }
}
