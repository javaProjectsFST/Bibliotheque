
package controller.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.Employe;

public class EmployesCRUD {
    private Connection connexion;    

    public EmployesCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addEmploye(Employe employe){
         try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO employe (MdpEmploye,Login,Prenom,Nom) VALUES (?,?,?,?)");
            prepare.setString(1, employe.getMdp());
            prepare.setString(2, employe.getLogin());
            prepare.setString(3, employe.getPrenom() );
            prepare.setString(4, employe.getNom());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Employe getEmployeBy(String mdp){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM employe WHERE MdpEmploye =?");
            prepare.setString(1,mdp);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Employe employe=new Employe();
                while ( resultat.next() )
                {
                    employe.setMdp(resultat.getString("MdpEmploye"));
                    employe.setPrenom(resultat.getString("Login"));
                    employe.setPrenom(resultat.getString("Prenom"));
                    employe.setNom(resultat.getString("Nom")); 
                }
                prepare.close();    
                resultat.close();
                return(employe);
            }else{
                return (null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Employe getEmployeBy(String mdp,String login){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM employe WHERE MdpEmploye =? AND Login=?");
            prepare.setString(1,mdp);
            prepare.setString(2,login);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Employe employe=new Employe();
                while ( resultat.next() ){
                    employe.setMdp(resultat.getString("MdpEmploye"));
                    employe.setPrenom(resultat.getString("Login"));
                    employe.setPrenom(resultat.getString("Prenom"));
                    employe.setNom(resultat.getString("Nom")); 
                }
                prepare.close();    
                resultat.close();
                return(employe);
            }else{
                return(null);
            }
        }catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean deleteEmployeBy(String mdp){
         try{
             PreparedStatement prepare=connexion.prepareStatement("DELETE FROM employe WHERE MdpEmploye=?");
             prepare.setString(1,mdp);
             prepare.executeUpdate();
             prepare.close();
             return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public boolean updateEmploye(String mdp, Employe employe){
         try{
            PreparedStatement prepare=connexion.prepareStatement("UPDATE employe SET MdpEmploye=?,Login=?,Prenom=?,Nom=? WHERE MdpEmploye=?");
            prepare.setString(1,employe.getMdp());
            prepare.setString(2,employe.getLogin());
            prepare.setString(3,employe.getPrenom());
            prepare.setString(4,employe.getNom());
            prepare.setString(5,mdp);

            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public ResultSet getAllEmployes(){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from employe");
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
