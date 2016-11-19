
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
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO employe (Login,MdpEmploye,Prenom,Nom) VALUES (?,?,?,?)");
            prepare.setString(1, employe.getLogin());
            prepare.setString(2, employe.getMdp());
            prepare.setString(3, employe.getPrenom() );
            prepare.setString(4, employe.getNom());
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Employe getEmployeBy(String login){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM employe WHERE Login =?");
            prepare.setString(1,login);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Employe employe=new Employe();
                while ( resultat.next() )
                {
                    employe.setMdp(resultat.getString("MdpEmploye"));
                    employe.setLogin(resultat.getString("Login"));
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
    
    public Employe getEmployeBy(String login,String mdp){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM employe WHERE Login=? AND MdpEmploye =?");
            prepare.setString(1,login);
            prepare.setString(2,mdp);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Employe employe=new Employe();
                while ( resultat.next() ){
                    employe.setMdp(resultat.getString("MdpEmploye"));
                    employe.setLogin(resultat.getString("Login"));
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
    
    public boolean deleteEmployeBy(String login){
         try{
             PreparedStatement prepare=connexion.prepareStatement("DELETE FROM employe WHERE MdpEmploye=?");
             prepare.setString(1,login);
             prepare.executeUpdate();
             prepare.close();
             return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public boolean updateEmploye(String login, Employe employe){
         try{
            PreparedStatement prepare=connexion.prepareStatement("UPDATE employe SET Login=?,MdpEmploye=?,Prenom=?,Nom=? WHERE Login=?");
            prepare.setString(1,employe.getLogin());
            prepare.setString(2,employe.getMdp());
            prepare.setString(3,employe.getPrenom());
            prepare.setString(4,employe.getNom());
            prepare.setString(5,login);

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
