package controller.CRUD;

import java.sql.Connection;
import java.util.Vector;
import model.Livre;

public class LivresCRUD {
    private Connection Connexion;
    private EmpruntsCRUD emprentCrud;
    private ReservationsCRUD reservationCrud;

    public LivresCRUD(Connection connexion) {
        this.Connexion = Connexion;
        emprentCrud=new EmpruntsCRUD(connexion);
        reservationCrud=new ReservationsCRUD(connexion);
    }
    
    public boolean addLivre(Livre livre){
        return true;
    }
    
    public Livre getLivreBy(int livreId){
        return null;
    }
    
    public boolean deleteLivreBy(int livreId){
        return true;
    }
    
    public boolean updateLivre(int livreId, Livre livre){
        return true;
    }
    
    public Vector<Livre> getAllLivres(){
        return null;
    }
}
