
package model.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.entities.Emprunt;

public class EmpruntsCRUD {
    private final Connection connexion;
    private final LivresCRUD livresCrud;
    private final AdherentsCRUD adherentCrud;

    public EmpruntsCRUD(Connection connexion, LivresCRUD livreCrud, AdherentsCRUD adherentCrud) {
        this.connexion = connexion;
        this.livresCrud=livreCrud;
        this.adherentCrud=adherentCrud;
    }
    
    public boolean addEmprent(Emprunt emprunt){
        try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO emprunt(IdLivreEmp,LoginAdherentEmp,DateEmprunt,DateLimiteEmprunt) VALUES (?,?,?,?)");
            prepare.setInt(1, emprunt.getIdLivreEmp());
            prepare.setString(2, emprunt.getLoginAdherentEmp());
            prepare.setDate(3, emprunt.getDateEmprunt());
            prepare.setDate(4, emprunt.getDateLimiteEmprunt());

            prepare.executeUpdate();
            updateView();
            prepare.close();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    private void updateView(){
        livresCrud.updateView();
    }
    
    public Emprunt getEmprentByLivre(int IdLivreEmp){
         try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM emprunt WHERE IdLivreEmp=?");
            prepare.setInt(1,IdLivreEmp);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Emprunt emprunt=new Emprunt();
                while ( resultat.next() )
                {

                    emprunt.setIdLivreEmp(resultat.getInt("IdLivreEmp"));
                    emprunt.setLoginAdherentEmp(resultat.getString("LoginAdherentEmp"));
                    emprunt.setDateEmprunt(resultat.getDate("DateEmprunt"));
                    emprunt.setDateLimiteEmprunt(resultat.getDate("DateLimiteEmprunt"));

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
    
    public ResultSet getEmprentsByAdherent(String LoginAdherentEmp){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from emprunt WHERE LoginAdherentEmp=?");
            prepare.setString(1,LoginAdherentEmp);
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
    
    public Emprunt getEmprentBy(int IdLivreEmp, String LoginAdherentEmp){
          try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM emprunt WHERE IdLivreEmp =? AND LoginAdherentEmp=?");
            prepare.setInt(1,IdLivreEmp);
            prepare.setString(2,LoginAdherentEmp);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Emprunt emprunt=new Emprunt();
                while ( resultat.next() )
                {
                    emprunt.setIdLivreEmp(resultat.getInt("IdLivreEmp"));
                    emprunt.setLoginAdherentEmp(resultat.getString("LoginAdherentEmp"));
                    emprunt.setDateEmprunt(resultat.getDate("DateEmprunt"));
                    emprunt.setDateLimiteEmprunt(resultat.getDate("DateLimiteEmprunt"));
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
    
    public boolean deleteEmprentBy(int IdLivreEmp, String LoginAdherentEmp){
         try{
             PreparedStatement prepare=connexion.prepareStatement("DELETE FROM emprunt WHERE IdLivreEmp=? AND LoginAdherentEmp=?");
             prepare.setInt(1,IdLivreEmp);
             prepare.setString(2,LoginAdherentEmp);
             prepare.executeUpdate();
             updateView();
             prepare.close();
             return true;
        }
        catch(SQLException ex) {
            return false;
        }
       
    }
    
    public int deleteEmprentsByAdherent(String LoginAdherentEmp){
         /*try{
             PreparedStatement prepare=connexion.prepareStatement("DELETE FROM emprunt WHERE LoginAdherentEmp=?");
             prepare.setString(1,LoginAdherentEmp);
             prepare.executeUpdate();
             updateView();
             prepare.close();
             return true;
        }
        catch(SQLException ex) {
            return false;
        }*/
         return 0;
    }
    
    public boolean deleteEmprentByLivre(int IdLivreEmp){
         try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM emprunt WHERE IdLivreEmp=?");
            prepare.setInt(1,IdLivreEmp);
            prepare.executeUpdate();
            updateView();
            prepare.close();
            return true;
        }
        catch(SQLException ex) {
            return false;
        }
    }
    
    public ResultSet getEmprentsAtDate(Date date){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM emprunt WHERE DateEmprunt=?");
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
