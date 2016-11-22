
package model.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Reservation {
    private int IdLivreRes;
    private String LoginAdherentRes;
    private Date DateReservation;
    private Date DateLimiteReservation;
    
    public Reservation(){
        
    }

    public Reservation(int IdLivreRes, String LoginAdherentRes) {
        this.IdLivreRes = IdLivreRes;
        this.LoginAdherentRes = LoginAdherentRes;
        
        this.DateReservation = new Date(System.currentTimeMillis());
        
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Calendar cal=Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        ts.setTime(cal.getTime().getTime());
        this.DateLimiteReservation = new Date(ts.getTime());
    }

    public int getIdLivreRes() {
        return IdLivreRes;
    }

    public void setIdLivreRes(int IdLivreRes) {
        this.IdLivreRes = IdLivreRes;
    }

    public String getLoginAdherentRes() {
        return LoginAdherentRes;
    }

    public void setLoginAdherentRes(String LoginAdherentRes) {
        this.LoginAdherentRes = LoginAdherentRes;
    }

    public Date getDateReservation() {
        return DateReservation;
    }

    public void setDateReservation(Date DateReservation) {
        this.DateReservation = DateReservation;
    }

    public Date getDateLimiteReservation() {
        return DateLimiteReservation;
    }

    public void setDateLimiteReservation(Date DateLimiteReservation) {
        this.DateLimiteReservation = DateLimiteReservation;
    }
}
