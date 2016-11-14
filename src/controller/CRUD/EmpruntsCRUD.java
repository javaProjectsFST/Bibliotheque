
package controller.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;
import model.Emprunt;

public class EmpruntsCRUD {
    private Connection connexion;

    public EmpruntsCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addEmprent(Emprunt emprent){
        return true;
    }
    
    public Emprunt getEmprentByLivre(int livreId){
        return null;
    }
    
    public Vector<Emprunt> getEmprentsByAdherent(String mdpAdherent){
        return null;
    }
    
    public Emprunt getEmprentBy(int livreId, String mdpAdherent){
        return null;
    }
    
    public Vector<Emprunt> getAllEmprents(){
        return null;
    }
    
    public Vector<Emprunt> getDepLimEmprents(){
        return null;
    }
    
    public boolean deleteEmprentBy(int livreId, String mdpAdherent){
        return true;
    }
    
    public int deleteEmprentsByAdherent(String mdpAdherent){
        return 0;
    }
    
    public boolean deleteEmprentByLivre(int livreId){
        return true;
    }
    
    public Vector<Emprunt> getEmprentsAtDate(Date date){
        return null;
    }
}
