
package controller.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;
import model.Reservation;

public class ReservationsCRUD {
    private Connection connexion;

    public ReservationsCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addReservation(Reservation reservation){
        return true;
    }
    
    public Reservation getReservationByLivre(int livreId){
        return null;
    }
    
    public Vector<Reservation> getReservationsByAdherent(String mdpAdherent){
        return null;
    }
    
    public Reservation getReservationBy(int livreId, String mdpAdherent){
        return null;
    }
    
    public Vector<Reservation> getAllReservations(){
        return null;
    }
    
    public Vector<Reservation> getDepLimReservation(){
        return null;
    }
    
    public boolean deleteReservationBy(int livreId, String mdpAdherent){
        return true;
    }
    
    public int deleteReservationsByAdherent(String mdpAdherent){
        return 0;
    }
    
    public boolean deleteReservationByLivre(int livreId){
        return true;
    }
    
    public Vector<Reservation> getReservationsAtDate(Date date){
        return null;
    }
}
