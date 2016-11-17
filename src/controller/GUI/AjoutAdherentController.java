
package controller.GUI;

import View.AjoutAdherentView;
import controller.CRUD.AdherentsCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class AjoutAdherentController {
    private AdherentsCRUD adherentCrud;
    private AjoutAdherentView ajoutAdherentView;
    private Connection connexion;
    
    public AjoutAdherentController(AjoutAdherentView ajoutAdherentView, Connection connexion){
        this.adherentCrud=new AdherentsCRUD(connexion);
        this.ajoutAdherentView=ajoutAdherentView;
        this.connexion=connexion;
        
        initView();
        initController();
    }
    
    public void initView(){
        
    }
    
    public void initController(){
        ajoutAdherentView.getAjoutButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                addAdherent();
            }
        });
        //ActionListeners goes here
    }
    
    private boolean addAdherent(){
        //Add Code Here, Using ajoutAdherentCrud
        return true;
    }
}
