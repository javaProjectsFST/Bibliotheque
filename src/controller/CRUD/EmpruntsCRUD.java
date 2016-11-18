
package controller.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.Emprunt;

public class EmpruntsCRUD {
    private Connection connexion;

    public EmpruntsCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addEmprent(Emprunt emprent){
        try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO emprunt(LivreId,MdpAdherent,DateEmprent,DateLimiteEmprent) VALUES (?,?,?,?)");
            prepare.setInt(1, emprent.getLivreId());
            prepare.setString(2, emprent.getMdpAdherent());
            prepare.setDate(3, emprent.getDateEmprent());
            prepare.setDate(4, emprent.getDateLimiteEmprent());
            
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Emprunt getEmprentByLivre(int livreId){
         try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM emprunt WHERE LivreId=?");
            prepare.setInt(1,livreId);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Emprunt emprunt=new Emprunt();
                while ( resultat.next() )
                {

                    emprunt.setLivreId(resultat.getInt("LivreId"));
                    emprunt.setMdpAdherent(resultat.getString("MdpAdherent"));
                    emprunt.setDateEmprent(resultat.getDate("DateEmprent"));
                    emprunt.setDateLimiteEmprent(resultat.getDate("DateLimiteEmprent"));

                }
                prepare.close();    
                resultat.close();
                return(emprunt);
            }else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getEmprentsByAdherent(String mdpAdherent){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from emprunt WHERE MdpAdherent=?");
            prepare.setString(1,mdpAdherent);
            ResultSet resultat=prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                return (resultat);
            }
            else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Emprunt getEmprentBy(int livreId, String mdpAdherent){
          try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM emprunt WHERE LivreId =? AND MdpAdherent=?");
            prepare.setInt(1,livreId);
            prepare.setString(2,mdpAdherent);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Emprunt emprunt=new Emprunt();
                while ( resultat.next() )
                {
                    emprunt.setLivreId(resultat.getInt("LivreId"));
                    emprunt.setMdpAdherent(resultat.getString("MdpAdherent"));
                    emprunt.setDateEmprent(resultat.getDate("DateEmprent"));
                    emprunt.setDateLimiteEmprent(resultat.getDate("DateLimiteEmprent"));
                }
                prepare.close();    
                resultat.close();
                return(emprunt);
            }else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getAllEmprents(){
          try {
            PreparedStatement prepare=connexion.prepareStatement("select * from emprunt");
            ResultSet resultat=prepare.executeQuery();
            if(resultat.next()){
             resultat.beforeFirst();
             return (resultat);
            }
            else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public Vector<Emprunt> getDepLimEmprents(){
        return null;
    }
    
    public boolean deleteEmprentBy(int livreId, String mdpAdherent){
         try{
             PreparedStatement prepare=connexion.prepareStatement("DELETE FROM emprunt WHERE LivreId=? AND MdpAdherent=?");
             prepare.setInt(1,livreId);
             prepare.setString(2,mdpAdherent);
             prepare.executeUpdate();
             prepare.close();
             return true;
        }
        catch(SQLException ex) {
            return false;
        }
       
    }
    
    public int deleteEmprentsByAdherent(String mdpAdherent){
         /*try{
             PreparedStatement prepare=connexion.prepareStatement("DELETE FROM emprunt WHERE MdpAdherent=?");
             prepare.setString(1,mdpAdherent);
             prepare.executeUpdate();
             prepare.close();
             return true;
        }
        catch(SQLException ex) {
            return false;
        }*/
         return 0;
    }
    
    public boolean deleteEmprentByLivre(int livreId){
         try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM emprunt WHERE LivreId=?");
            prepare.setInt(1,livreId);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }
    
    public ResultSet getEmprentsAtDate(Date date){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM emprunt WHERE DateEmprent=?");
            prepare.setDate(1,date);
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
