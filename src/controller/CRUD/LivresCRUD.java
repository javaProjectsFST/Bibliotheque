package controller.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Livre;

public class LivresCRUD {
    private Connection connexion;
    private EmpruntsCRUD emprentCrud;
    private ReservationsCRUD reservationCrud;

    public LivresCRUD(Connection connexion) {
        this.connexion = connexion;
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
    
    public ResultSet getAllLivres(){
        try {
            PreparedStatement prepare=connexion.prepareStatement("select * from livre");
            return (prepare.executeQuery());
        } catch (SQLException ex) {
            return null;
        }
    }
}
