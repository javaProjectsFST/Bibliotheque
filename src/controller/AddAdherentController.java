
package controller;

import controller.main.MainClass;
import java.awt.Window;
import model.CRUD.AdherentsCRUD;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.entities.Adherent;
import view.AddAdherentView;
import view.AdherentsView;

public class AddAdherentController {
    private final AdherentsCRUD adherentCrud;
    private final AddAdherentView ajoutAdherentView;
    private final Connection connexion;
    private final AdherentsView adherentView;
    
    public AddAdherentController(Connection connexion, AdherentsView adherentView){
        this.adherentCrud=new AdherentsCRUD(connexion, adherentView);
        this.ajoutAdherentView=new AddAdherentView();
        this.connexion=connexion;
        this.adherentView=adherentView;
        
        initView();
        initController();
        
        JOptionPane.showOptionDialog(null, this.ajoutAdherentView, "Ajouter un  Adherent", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    public void initView(){
        
    }
    
    public void initController(){
        ajoutAdherentView.getAjouterButton().addActionListener(e->addAdherent());
        ajoutAdherentView.getResetButton().addActionListener(e-> reset());
    }
    
    private void reset(){
        ajoutAdherentView.getMdpTextField().setText("");
        ajoutAdherentView.getLoginTextField().setText("");
        ajoutAdherentView.getNomTextField().setText("");
        ajoutAdherentView.getPrenomTextField().setText("");
        ajoutAdherentView.getEmailTextField().setText("");
    }
    
    private boolean addAdherent(){
        String mdp=ajoutAdherentView.getMdpTextField().getText();
        String login=ajoutAdherentView.getLoginTextField().getText();
        String nom=ajoutAdherentView.getNomTextField().getText();
        String prenom=ajoutAdherentView.getPrenomTextField().getText();
        String email=ajoutAdherentView.getEmailTextField().getText();
       
        if(nom.isEmpty()){
            JOptionPane.showMessageDialog(ajoutAdherentView, "Champs nom est obligatoire!");
            return false;
        }else if(prenom.isEmpty()){
            JOptionPane.showMessageDialog(ajoutAdherentView, "Champs prenom est obligatoire!");
            return false;
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(ajoutAdherentView, "Champs email est obligatoire!");
            return false;
        }else if(login.isEmpty()){
            JOptionPane.showMessageDialog(ajoutAdherentView, "Champs login est obligatoire!");
            return false;
        }else if(mdp.isEmpty()){
            JOptionPane.showMessageDialog(ajoutAdherentView, "Champs mot de passe est obligatoire!");
            return false;
        }else if(!MainClass.isValidEmail(email)){
            JOptionPane.showMessageDialog(ajoutAdherentView, "Email Invalid!");
            return false;
        }else{
            if(adherentCrud.getAdherentBy(login)!=null){
                JOptionPane.showMessageDialog(ajoutAdherentView, "Login existant!");
                return false;
            }else{
                Adherent adherent=new Adherent();
                adherent.setNom(nom);
                adherent.setPrenom(prenom);
                adherent.setEmail(email);
                adherent.setLogin(login);
                adherent.setMdp(mdp);
                
                if(adherentCrud.addAdherent(adherent)){
                    ((Window)SwingUtilities.getWindowAncestor(this.ajoutAdherentView)).dispose();
                    return true;
                }
                return false;
            }
        }
    }
}
