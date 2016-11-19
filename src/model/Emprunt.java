
package model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;


public class Emprunt {
    private int IdLivreEmp;
    private String LoginAdherentEmp;
    private Date DateEmprent;
    private Date DateLimiteEmprent;
    
    public Emprunt(){
        
    }

    public Emprunt(int IdLivreEmp, String LoginAdherentEmp) {
        this.IdLivreEmp = IdLivreEmp;
        this.LoginAdherentEmp = LoginAdherentEmp;
        
        this.DateEmprent = new Date(System.currentTimeMillis());
        
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Calendar cal=Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        ts.setTime(cal.getTime().getTime());
        this.DateLimiteEmprent = new Date(ts.getTime());
    }

    public int getIdLivreEmp() {
        return IdLivreEmp;
    }

    public void setIdLivreEmp(int IdLivreEmp) {
        this.IdLivreEmp = IdLivreEmp;
    }

    public String getLoginAdherentEmp() {
        return LoginAdherentEmp;
    }

    public void setLoginAdherentEmp(String LoginAdherentEmp) {
        this.LoginAdherentEmp = LoginAdherentEmp;
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
