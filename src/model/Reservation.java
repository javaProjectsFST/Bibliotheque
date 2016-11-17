
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Reservation {
    private int LivreId;
    private String MdpAdherent;
    private Date DateReservation;
    private Date DateLimiteReservation;
    
    public Reservation(){
        
    }

    public Reservation(int LivreId, String MdpAdherent) {
        this.LivreId = LivreId;
        this.MdpAdherent = MdpAdherent;
        
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

    public String getMdpAdherent() {
        return MdpAdherent;
    }

    public void setMdpAdherent(String MdpAdherent) {
        this.MdpAdherent = MdpAdherent;
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
