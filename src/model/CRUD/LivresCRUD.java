package model.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entities.Livre;
import view.LivresView;

public class LivresCRUD {
    private Connection connexion;
    private final LivresView livreView;
    
    public LivresCRUD(Connection connexion, LivresView livreView) {
        this.connexion = connexion;
        this.livreView=livreView;
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
            updateView();
            return true; 
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public int getLivresCount(){
        try{
            PreparedStatement prepare=connexion.prepareStatement("SELECT COUNT(*) FROM livre");
            ResultSet rs=prepare.executeQuery();
            rs.next();
            return rs.getInt(1);
        }catch(SQLException ex){
            ex.printStackTrace();
            return -1;
        }
    }
    
    public void updateView(){
        ResultSet rs=getAllLivres(true);
        if(rs!=null){
            livreView.UpdateView(rs);
        }
    }
    
    public ResultSet searchLivreByTitre(String titre){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId) AS T WHERE Titre LIKE ? ORDER BY Titre");
            prepare.setString(1, titre+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet searchLivreByAuteur(String auteur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId) AS T WHERE Auteur LIKE ? ORDER BY Titre");
            prepare.setString(1, auteur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByEditeur(String editeur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId) AS T WHERE Editeur LIKE ? ORDER BY Titre");
            prepare.setString(1, editeur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public ResultSet searchLivreByTitreInEmprunt(String titre){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = e.IdLivreEmp) AS T WHERE Titre LIKE ? ORDER BY Titre");
            prepare.setString(1, titre+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByAuteurInEmprunt(String auteur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = e.IdLivreEmp) AS T WHERE Auteur LIKE ? ORDER BY Titre");
            prepare.setString(1, auteur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByEditeurInEmprunt(String editeur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = e.IdLivreEmp) AS T WHERE Editeur LIKE ? ORDER BY Titre");
            prepare.setString(1, editeur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    
    public ResultSet searchLivreByTitreInReservation(String titre){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = r.IdLivreRes) AS T WHERE Titre LIKE ? ORDER BY Titre");
            prepare.setString(1, titre+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByAuteurInReservation(String auteur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = r.IdLivreRes) AS T WHERE Auteur LIKE ? ORDER BY Titre");
            prepare.setString(1, auteur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByEditeurInReservation(String editeur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = r.IdLivreRes) AS T WHERE Editeur LIKE ? ORDER BY Titre");
            prepare.setString(1, editeur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByTitreInDateLim(String titre){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE CURDATE() >= e.DateLimiteEmprunt) AS T WHERE Titre LIKE ? ORDER BY Titre");
            prepare.setString(1, titre+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByAuteurInDateLim(String auteur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE CURDATE() >= e.DateLimiteEmprunt) AS T WHERE Auteur LIKE ? ORDER BY Titre");
            prepare.setString(1, auteur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ResultSet searchLivreByEditeurInDateLim(String editeur){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE CURDATE() >= e.DateLimiteEmprunt) AS T WHERE Editeur LIKE ? ORDER BY Titre");
            prepare.setString(1, editeur+"%");
            return prepare.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
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
            updateView();
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
    
    public ResultSet getAllLivres(boolean details){
        try {
            PreparedStatement prepare;
            if(!details){
                prepare=connexion.prepareStatement("select * from livre");
            }else{
                prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId) AS T ORDER BY Titre");
            }
            ResultSet resultat=prepare.executeQuery();
            
            resultat.beforeFirst();
            return (resultat);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getAllLivresInEmprunt(boolean details){
        try {
            PreparedStatement prepare;
            if(!details){
                prepare=connexion.prepareStatement("select * from livre");
            }else{
                prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = e.IdLivreEmp) AS T ORDER BY Titre");
            }
            ResultSet resultat=prepare.executeQuery();
 
            resultat.beforeFirst();
            return (resultat);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getAllLivresInReservation(boolean details){
        try {
            PreparedStatement prepare;
            if(!details){
                prepare=connexion.prepareStatement("select * from livre");
            }else{
                prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE l.LivreId = r.IdLivreRes) AS T ORDER BY Titre");
            }
            ResultSet resultat=prepare.executeQuery();
            resultat.beforeFirst();
            return (resultat);
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getAllLivresInDateLim(boolean details){
        try {
            PreparedStatement prepare;
            if(!details){
                prepare=connexion.prepareStatement("select * from livre");
            }else{
                prepare=connexion.prepareStatement("SELECT LivreId, Titre, Auteur, Editeur, DateEdition, DateEmprunt, DateLimiteEmprunt, DateReservation, DateLimiteReservation FROM (SELECT * FROM livre l LEFT JOIN emprunt e ON e.IdLivreEmp = l.LivreId LEFT JOIN reservation r ON r.IdLivreRes = l.LivreId WHERE CURDATE() >= e.DateLimiteEmprunt) AS T ORDER BY Titre");
            }
            ResultSet resultat=prepare.executeQuery();
            resultat.beforeFirst();
            return (resultat);
        } catch (SQLException ex) {
            return null;
        }
    }
}
