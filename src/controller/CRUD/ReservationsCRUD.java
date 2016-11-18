
package controller.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.ResultSet;
import model.Reservation;

public class ReservationsCRUD {
    private Connection connexion;

    public ReservationsCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addReservation(Reservation reservation){
         try {
            PreparedStatement prepare=connexion.prepareStatement("INSERT INTO reservation(LivreId,MdpAdherent,DateReservation,DateLimiteReservation) VALUES (?,?,?,?)");
            prepare.setInt(1, reservation.getLivreId());
            prepare.setString(2, reservation.getMdpAdherent());
            prepare.setDate(3, reservation.getDateReservation());
            prepare.setDate(4, reservation.getDateLimiteReservation());
            
            prepare.executeUpdate();
            prepare.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public Reservation getReservationByLivre(int livreId){
        try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM reservation WHERE LivreId=?");
            prepare.setInt(1,livreId);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst();
                Reservation reservation=new Reservation();
                while ( resultat.next() )
                {

                    reservation.setLivreId(resultat.getInt("LivreId"));
                    reservation.setMdpAdherent(resultat.getString("MdpAdherent"));
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
    
    public ResultSet getReservationsByAdherent(String mdpAdherent){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from reservation WHERE MdpAdherent=?");
            prepare.setString(1,mdpAdherent);
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
    
    public Reservation getReservationBy(int livreId, String mdpAdherent){
       try {
            PreparedStatement prepare=connexion.prepareStatement("SELECT * FROM reservationt WHERE LivreId =? AND MdpAdherent=?");
            prepare.setInt(1,livreId);
            prepare.setString(2,mdpAdherent);
            ResultSet resultat = prepare.executeQuery();
            if(resultat.next()){
                resultat.beforeFirst(); 
                Reservation reservation=new Reservation();
                while ( resultat.next() ){
                    reservation.setLivreId(resultat.getInt("LivreId"));
                    reservation.setMdpAdherent(resultat.getString("MdpAdherent"));
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
    
    public boolean deleteReservationBy(int livreId, String mdpAdherent){
         try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM reservation WHERE LivreId=? AND MdpAdherent=?");
            prepare.setInt(1,livreId);
            prepare.setString(2,mdpAdherent);
            prepare.executeUpdate();
            prepare.close();
            return true;
        }catch(SQLException ex) {
            return false;
        }
    }
    
    public int deleteReservationsByAdherent(String mdpAdherent){
        return 0;
    }
    
    public boolean deleteReservationByLivre(int livreId){
         try{
            PreparedStatement prepare=connexion.prepareStatement("DELETE FROM reservation WHERE LivreId=?");
            prepare.setInt(1,livreId);
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
