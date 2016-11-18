
package controller.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.Adherent;
import model.Livre;

public class AdherentsCRUD {
    private Connection connexion;

    public AdherentsCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addAdherent(Adherent adherent){
         try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO adherent (MdpAdherent,Login,Prenom,Nom,Email) VALUES (?,?,?,?,?)");
            prepare.setString(1, adherent.getMdp());
            prepare.setString(2, adherent.getLogin());
            prepare.setString(3,adherent.getPrenom() );
            prepare.setString(4, adherent.getNom());
            prepare.setString(4, adherent.getEmail());
            
            prepare.executeUpdate();
            prepare.close();
            return true;
            
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    public Adherent getAdherentBy(String mdp){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM adherent WHERE MdpAdherent =?");
            prepare.setString(1,mdp);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst(); //reinitialisation du pointeur sur l'element avant premier
                Adherent adherent=new Adherent();
                while (resultat.next()){
                    adherent.setMdp(resultat.getString("MdpAdherent"));
                    adherent.setPrenom(resultat.getString("Login"));
                    adherent.setPrenom(resultat.getString("Prenom"));
                    adherent.setNom(resultat.getString("Nom"));
                    adherent.setEmail(resultat.getString("Email"));
                }
                prepare.close();    
                resultat.close();
                return(adherent);
            }else{
                return null;
            }
        }catch (SQLException ex) {
            return null;
        }
    }
     public Adherent getAdherentBy(String mdp,String login){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM adherent WHERE MdpAdherent =? AND Login=?");
            prepare.setString(1,mdp);
            prepare.setString(2,login);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Adherent adherent=new Adherent();
                while (resultat.next()){
                    adherent.setMdp(resultat.getString("MdpAdherent"));
                    adherent.setPrenom(resultat.getString("Login"));
                    adherent.setPrenom(resultat.getString("Prenom"));
                    adherent.setNom(resultat.getString("Nom"));
                    adherent.setEmail(resultat.getString("Email"));
                }
                prepare.close();    
                resultat.close();
                return(adherent);
            }
            else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean deleteAdherentBy(String mdp){
       try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM adherent WHERE MdpAdherent=?");
            prepare.setString(1,mdp);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }
    
    public boolean updateAdherent(String mdp, Adherent adherent){
        try{
            PreparedStatement prepare=connexion.prepareStatement("UPDATE adherent SET MdpAdherent=?,Login=?,Prenom=?,Nom=?,Email=? WHERE MdpAdherent=?");
            prepare.setString(1,adherent.getMdp());
            prepare.setString(2,adherent.getLogin());
            prepare.setString(3,adherent.getPrenom());
            prepare.setString(4, adherent.getNom());
            prepare.setString(5,adherent.getEmail());
            prepare.setString(6,mdp);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public ResultSet getAllAdherents(){
         try {
            PreparedStatement prepare=connexion.prepareStatement("select * from adherent");
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
    
    public void sendAvetMail(Livre livre){
        
    }
}
