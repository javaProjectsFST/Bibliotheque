
package model.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSet;
import model.entities.Reservation;

public class ReservationsCRUD {
    private final Connection connexion;
    private final LivresCRUD livresCrud;
    
    public ReservationsCRUD(Connection connexion, LivresCRUD livresCrud) {
        this.connexion = connexion;
        this.livresCrud=livresCrud;
    }
    
    public void UpdateView(){
        livresCrud.updateView();
    }
    
    public boolean addReservation(Reservation reservation){
         try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO reservation(IdLivreRes,LoginAdherentRes,DateReservation,DateLimiteReservation) VALUES (?,?,?,?)");
            prepare.setInt(1, reservation.getIdLivreRes());
            prepare.setString(2, reservation.getLoginAdherentRes());
            prepare.setDate(3, reservation.getDateReservation());
            prepare.setDate(4, reservation.getDateLimiteReservation());
            
            prepare.executeUpdate();
            UpdateView();
            prepare.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Reservation getReservationByLivre(int IdLivreRes){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM reservation WHERE IdLivreRes=?");
            prepare.setInt(1,IdLivreRes);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Reservation reservation=new Reservation();
                while ( resultat.next() )
                {

                    reservation.setIdLivreRes(resultat.getInt("IdLivreRes"));
                    reservation.setLoginAdherentRes(resultat.getString("LoginAdherentRes"));
                    reservation.setDateReservation(resultat.getDate("DateReservation"));
                    reservation.setDateLimiteReservation(resultat.getDate("DateLimiteReservation"));

                }
                prepare.close();    
                resultat.close();
                return(reservation);
            }else{
                return(null);
            }
        }catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getReservationsByAdherent(String LoginAdherentRes){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from reservation WHERE LoginAdherentRes=?");
            prepare.setString(1,LoginAdherentRes);
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
    
    public Reservation getReservationBy(int IdLivreRes, String LoginAdherentRes){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM reservationt WHERE IdLivreRes =? AND LoginAdherentRes=?");
            prepare.setInt(1,IdLivreRes);
            prepare.setString(2,LoginAdherentRes);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst(); 
                Reservation reservation=new Reservation();
                while ( resultat.next() ){
                    reservation.setIdLivreRes(resultat.getInt("IdLivreRes"));
                    reservation.setLoginAdherentRes(resultat.getString("LoginAdherentRes"));
                    reservation.setDateReservation(resultat.getDate("DateReservation"));
                    reservation.setDateLimiteReservation(resultat.getDate("DateLimiteReservation"));
                }
                prepare.close();    
                resultat.close();
                return(reservation);
            }else{
                return(null);
            }
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public ResultSet getAllReservations(){
         try {
            PreparedStatement prepare=connexion.prepareStatement("select * from reservation");
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
    
    public Vector<Reservation> getDepLimReservation(){
        return null;
    }
    
    public boolean deleteReservationBy(int IdLivreRes, String LoginAdherentRes){
         try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM reservation WHERE IdLivreRes=? AND LoginAdherentRes=?");
            prepare.setInt(1,IdLivreRes);
            prepare.setString(2,LoginAdherentRes);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public int deleteReservationsByAdherent(String LoginAdherentRes){
        return 0;
    }
    
    public boolean deleteReservationByLivre(int IdLivreRes){
         try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM reservation WHERE IdLivreRes=?");
            prepare.setInt(1,IdLivreRes);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public ResultSet getReservationsAtDate(Date date){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM reservation WHERE DateReservation=?");
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
