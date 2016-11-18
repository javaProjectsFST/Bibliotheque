package controller.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Livre;

public class LivresCRUD {
    private Connection connexion;
    private EmpruntsCRUD emprentCrud;
    private ReservationsCRUD reservationCrud;

    public LivresCRUD(Connection connexion) {
        this.connexion = connexion;
        emprentCrud=new EmpruntsCRUD(connexion);
        reservationCrud=new ReservationsCRUD(connexion);
    }
    
    public boolean addLivre(Livre livre){
        try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO livre (Titre,Auteur,Editeur,DateEdition) VALUES (?,?,?,?)");
            prepare.setString(1, livre.getTitre());
            prepare.setString(2, livre.getAuteur());
            prepare.setString(3, livre.getEditeur());
            prepare.setDate(4, livre.getDateEdition());
            
            prepare.executeUpdate();
            prepare.close();
            return true;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public Livre getLivreBy(int livreId){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM livre WHERE LivreId=?");
            prepare.setInt(1,livreId);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Livre livre=new Livre();
                while ( resultat.next() ){
                    livre.setId(resultat.getInt("LivreId"));
                    livre.setTitre(resultat.getString("Titre"));
                    livre.setAuteur(resultat.getString("Auteur"));
                    livre.setEditeur(resultat.getString("Editeur"));
                    livre.setDateEdition(resultat.getDate("DateEdition"));
                }
                prepare.close();    
                resultat.close();
                return(livre);
            }else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }

    }
    
    public boolean deleteLivreBy(int livreId){
        try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM livre WHERE LivreId=?");
            prepare.setInt(1,livreId);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
       
    }
    
    public boolean updateLivre(int livreId, Livre livre){
        try{
            PreparedStatement prepare=connexion.prepareStatement("UPDATE livre SET Titre=?,Auteur=?,Editeur=?,DateEdition=? WHERE LivreId=?");
            prepare.setString(1, livre.getTitre());
            prepare.setString(2, livre.getAuteur());
            prepare.setString(3, livre.getEditeur());
            prepare.setDate(4, livre.getDateEdition());
            prepare.setInt(5,livreId);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
       
    }
    
    public ResultSet getAllLivres(){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from livre");
            ResultSet resultat=prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                return (resultat);
            }else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
}
