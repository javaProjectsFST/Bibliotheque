
package controller;

import controller.main.MainClass;
import java.awt.Window;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.CRUD.EmployesCRUD;
import model.entities.Employe;
import view.AddEmployeView;
import view.EmployesView;

public class AddEmployeController {
    private final EmployesCRUD employesCrud;
    private final AddEmployeView ajoutEmployeView;
    private final Connection connexion;
    private final EmployesView employeView;
    
    public AddEmployeController(Connection connexion, EmployesView employeView){
        this.employesCrud=new EmployesCRUD(connexion, employeView);
        this.ajoutEmployeView=new AddEmployeView();
        this.connexion=connexion;
        this.employeView=employeView;
        
        initView();
        initController();
        
        JOptionPane.showOptionDialog(null, this.ajoutEmployeView, "Ajouter un  Employe", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    public void initView(){
        
    }
    
    public void initController(){
        ajoutEmployeView.getAjouterButton().addActionListener(e->addEmploye());
        ajoutEmployeView.getResetButton().addActionListener(e-> reset());
    }
    
    private void reset(){
        ajoutEmployeView.getMdpTextField().setText("");
        ajoutEmployeView.getLoginTextField().setText("");
        ajoutEmployeView.getNomTextField().setText("");
        ajoutEmployeView.getPrenomTextField().setText("");
        ajoutEmployeView.getEmailTextField().setText("");
    }
    
    private boolean addEmploye(){
        String mdp=ajoutEmployeView.getMdpTextField().getText();
        String login=ajoutEmployeView.getLoginTextField().getText();
        String nom=ajoutEmployeView.getNomTextField().getText();
        String prenom=ajoutEmployeView.getPrenomTextField().getText();
        String email=ajoutEmployeView.getEmailTextField().getText();
       
        if(nom.isEmpty()){
            JOptionPane.showMessageDialog(ajoutEmployeView, "Champs nom est obligatoire!");
            return false;
        }else if(prenom.isEmpty()){
            JOptionPane.showMessageDialog(ajoutEmployeView, "Champs prenom est obligatoire!");
            return false;
        }else if(email.isEmpty()){
            JOptionPane.showMessageDialog(ajoutEmployeView, "Champs email est obligatoire!");
            return false;
        }else if(login.isEmpty()){
            JOptionPane.showMessageDialog(ajoutEmployeView, "Champs login est obligatoire!");
            return false;
        }else if(mdp.isEmpty()){
            JOptionPane.showMessageDialog(ajoutEmployeView, "Champs mot de passe est obligatoire!");
            return false;
        }else if(!MainClass.isValidEmail(email)){
            JOptionPane.showMessageDialog(ajoutEmployeView, "Email Invalid!");
            return false;
        }else{
            if(employesCrud.getEmployeBy(login)!=null){
                JOptionPane.showMessageDialog(ajoutEmployeView, "Login existant!");
                return false;
            }else{
                Employe employe=new Employe();
                employe.setNom(nom);
                employe.setPrenom(prenom);
                employe.setEmail(email);
                employe.setLogin(login);
                employe.setMdp(mdp);
                
                if(employesCrud.addEmploye(employe)){
                    ((Window)SwingUtilities.getWindowAncestor(this.ajoutEmployeView)).dispose();
                    return true;
                }
                return false;
            }
        }
    }
}
