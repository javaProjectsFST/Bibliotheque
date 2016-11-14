
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;


public class Emprunt {
    private int LivreId;
    private String MdpAdherent;
    private Date DateEmprent;
    private Date DateLimiteEmprent;

    public Emprunt(int LivreId, String MdpAdherent) {
        this.LivreId = LivreId;
        this.MdpAdherent = MdpAdherent;
        
        this.DateEmprent = new Date(System.currentTimeMillis());
        
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Calendar cal=Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        ts.setTime(cal.getTime().getTime());
        this.DateLimiteEmprent = new Date(ts.getTime());
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

    public Date getDateEmprent() {
        return DateEmprent;
    }

    public void setDateEmprent(Date DateEmprent) {
        this.DateEmprent = DateEmprent;
    }

    public Date getDateLimiteEmprent() {
        return DateLimiteEmprent;
    }

    public void setDateLimiteEmprent(Date DateLimiteEmprent) {
        this.DateLimiteEmprent = DateLimiteEmprent;
    }
}
