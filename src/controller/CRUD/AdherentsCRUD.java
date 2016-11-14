
package controller.CRUD;

import java.sql.Connection;
import java.util.Vector;
import model.Adherent;
import model.Livre;

public class AdherentsCRUD {
    private Connection connexion;

    public AdherentsCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addAdherent(Adherent adherent){
        return true;
    }
    
    public Adherent getAdherentBy(int id){
        return null;
    }
    
    public boolean deleteAdherentBy(int id){
        return true;
    }
    
    public boolean updateAdherent(int id, Adherent adherent){
        return true;
    }
    
    public Vector<Adherent> getAllAdherents(){
        return null;
    }
    
    public void sendAvetMail(Livre livre){
        
    }
}
