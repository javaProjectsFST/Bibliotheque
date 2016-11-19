
package controller.GUI;

import View.LivresView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmpruntsCRUD;
import controller.CRUD.LivresCRUD;
import controller.CRUD.ReservationsCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class LivresController {
    private LivresView livreView;
    private Connection connexion;
    private int sortColumn;
    private LivresCRUD livresCrud;
    private AdherentsCRUD adherentsCrud;
    private EmpruntsCRUD emprentsCrud;
    private ReservationsCRUD reservationsCRUD;

    public LivresController(LivresView livreView, Connection connexion) {
        this.livreView = livreView;
        this.connexion = connexion;
        this.sortColumn = 1;
        this.livresCrud = new LivresCRUD(connexion);
        this.adherentsCrud = new AdherentsCRUD(connexion);
        this.emprentsCrud = new EmpruntsCRUD(connexion);
        this.reservationsCRUD=new ReservationsCRUD(connexion);
        
        initView();
        initController();
    }
    
    private void initView(){
        ResultSet rs=livresCrud.getAllLivres(true);
        if(rs!=null){
            livreView.getLivresTable().setModel(DbUtils.resultSetToTableModel(rs));
        }
    }
    
    private void initController(){
        
    }
    
    private void sortBy(){
        
    }
    
    private void searchByFor(){
        
    }
    
    private void addLivre(){
        
    }
    
    private void deleteLivre(){
        
    }
    
    private void updateLivre(){
        
    }
    
    private void resLivre(){
        
    }
    
    private void empLivre(){
        
    }
    
    private void cancelResLivre(){
        
    }
    
    private void livreRendu(){
        
    }
    
    private void sendAvertMail(){
        
    }
    
    private void showAllLivres(){
        
    }
    
    private void showLivresDisp(){
        
    }
    
    private void showLivresEmp(){
        
    }
    
    private void showLivresDepDateEmp(){
        
    }
    
    private void showLivresRes(){
        
    }
    
    private void showLivresDepDateRes(){
        
    }
}
