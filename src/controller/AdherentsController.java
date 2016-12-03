
package controller;

import view.AdherentsView;
import model.CRUD.AdherentsCRUD;
import java.sql.Connection;
import java.sql.ResultSet;

public class AdherentsController {
    private AdherentsView adherentView;
    private Connection connexion;
    private AdherentsCRUD adherentsCrud;

    public AdherentsController(AdherentsView adherentView, Connection connexion) {
        this.adherentView = adherentView;
        this.connexion = connexion;
        this.adherentsCrud = new AdherentsCRUD(connexion, this.adherentView);
        
        initView();
        initController();
    }
    
    public AdherentsView getAdherentView(){
        return this.adherentView;
    }
    
    private void initView(){
        ResultSet rs=adherentsCrud.getAllAdherents(true, false);
        if(rs!=null){
            adherentView.UpdateView(rs);
        }
    }
    
    private void initController(){
        
    }
    
    private void sortBy(){
        
    }
    
    private void searchByFor(){
        
    }
    
    private void addAdherent(){
        
    }
    
    private void deleteAdherent(){
        
    }
    
    private void updateAdherent(){
        
    }
    
    private void sendAvertMail(){
        
    }
    
    private void refreshTable(){
        
    }
}
