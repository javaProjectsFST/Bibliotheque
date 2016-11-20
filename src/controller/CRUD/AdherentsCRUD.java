
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
            prepare.setString(1, adherent.getLogin());
            prepare.setString(2, adherent.getMdp());
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
    
    public Adherent getAdherentBy(String login){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM adherent WHERE Login =?");
            prepare.setString(1,login);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst(); //reinitialisation du pointeur sur l'element avant premier
                Adherent adherent=new Adherent();
                while (resultat.next()){
                    adherent.setMdp(resultat.getString("MdpAdherent"));
                    adherent.setLogin(resultat.getString("Login"));
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
    
    public Adherent getAdherentByEmail(String email){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM adherent WHERE Email=?");
            prepare.setString(1,email);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst(); //reinitialisation du pointeur sur l'element avant premier
                Adherent adherent=new Adherent();
                while (resultat.next()){
                    adherent.setMdp(resultat.getString("MdpAdherent"));
                    adherent.setLogin(resultat.getString("Login"));
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
    
    public Adherent getAdherentBy(String login,String mdp){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM adherent WHERE Login =? AND MdpAdherent=?");
            prepare.setString(1,login);
            prepare.setString(2,mdp);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Adherent adherent=new Adherent();
                while (resultat.next()){
                    adherent.setMdp(resultat.getString("MdpAdherent"));
                    adherent.setLogin(resultat.getString("Login"));
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
    
    public boolean deleteAdherentBy(String login){
       try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM adherent WHERE Login=?");
            prepare.setString(1,login);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }
    
    public boolean updateAdherent(String login, Adherent adherent){
        try{
            PreparedStatement prepare=connexion.prepareStatement("UPDATE adherent SET MdpAdherent=?,Login=?,Prenom=?,Nom=?,Email=? WHERE Login=?");
            prepare.setString(1,adherent.getMdp());
            prepare.setString(2,adherent.getLogin());
            prepare.setString(3,adherent.getPrenom());
            prepare.setString(4, adherent.getNom());
            prepare.setString(5,adherent.getEmail());
            prepare.setString(6,login);
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
    
    public void sendMail(String message){
        
    }
}
