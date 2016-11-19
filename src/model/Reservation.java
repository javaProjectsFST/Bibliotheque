
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Reservation {
    private int LivreId;
    private String Login;
    private Date DateReservation;
    private Date DateLimiteReservation;
    
    public Reservation(){
        
    }

    public Reservation(int LivreId, String Login) {
        this.LivreId = LivreId;
        this.Login = Login;
        
        this.DateReservation = new Date(System.currentTimeMillis());
        
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Calendar cal=Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        ts.setTime(cal.getTime().getTime());
        this.DateLimiteReservation = new Date(ts.getTime());
    }

    public int getLivreId() {
        return LivreId;
    }

    public void setLivreId(int LivreId) {
        this.LivreId = LivreId;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
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
