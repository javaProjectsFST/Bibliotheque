
package model.entities;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;


public class Emprunt {
    private int IdLivreEmp;
    private String LoginAdherentEmp;
    private Date DateEmprunt;
    private Date DateLimiteEmprunt;
    
    public Emprunt(){
        
    }

    public Emprunt(int IdLivreEmp, String LoginAdherentEmp) {
        this.IdLivreEmp = IdLivreEmp;
        this.LoginAdherentEmp = LoginAdherentEmp;
        
        this.DateEmprunt = new Date(System.currentTimeMillis());
        
        Timestamp ts=new Timestamp(System.currentTimeMillis());
        Calendar cal=Calendar.getInstance();
        cal.setTime(ts);
        cal.add(Calendar.DAY_OF_WEEK, 14);
        ts.setTime(cal.getTime().getTime());
        this.DateLimiteEmprunt = new Date(ts.getTime());
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

    public Date getDateEmprunt() {
        return DateEmprunt;
    }

    public void setDateEmprunt(Date DateEmprent) {
        this.DateEmprunt = DateEmprent;
    }

    public Date getDateLimiteEmprunt() {
        return DateLimiteEmprunt;
    }

    public void setDateLimiteEmprunt(Date DateLimiteEmprent) {
        this.DateLimiteEmprunt = DateLimiteEmprent;
    }
}
