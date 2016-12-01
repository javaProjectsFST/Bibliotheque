
package controller;

import view.AjoutAdherentView;
import model.CRUD.AdherentsCRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.entities.Adherent;

public class AddAdherentController {
    private AdherentsCRUD adherentCrud;
    private AjoutAdherentView ajoutAdherentView;
    private Connection connexion;
    
    public AddAdherentController(AjoutAdherentView ajoutAdherentView, Connection connexion){
//        this.adsherentCrud=new AdherentsCRUD(connexion,);
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
    }
    
    private boolean validEmail (String email){
        return(true);
    }
    
    private boolean addAdherent(){
        String mdp=ajoutAdherentView.getMdpTextField().getText();
        String login=ajoutAdherentView.getLoginTextField().getText();
        String nom=ajoutAdherentView.getNomTextField().getText();
        String prenom=ajoutAdherentView.getPrenomTextField().getText();
        String email=ajoutAdherentView.getEmailTextField().getText();
       
        if(validEmail(email))
        {
            Adherent adherent=new Adherent(mdp,login,nom,prenom,email);
            
           if (!adherentCrud.addAdherent(adherent)){
              
               return(false);
           }   
        }else{
            return(false);
        }
        return true;
    }
}
