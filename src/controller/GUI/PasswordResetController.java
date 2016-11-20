
package controller.GUI;

import View.PasswordResetView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import controller.MainClass;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.Adherent;
import model.Employe;

public class PasswordResetController {
    private final PasswordResetView passwordResetView;
    private final AdherentsCRUD adherentsCrud;
    private final EmployesCRUD employesCrud;
    private final Connection connexion;
    
    public PasswordResetController(Connection connexion){
        this.passwordResetView=new PasswordResetView();
        this.connexion=connexion;
        this.adherentsCrud=new AdherentsCRUD(connexion);
        this.employesCrud=new EmployesCRUD(connexion);
        initController();
        JOptionPane.showOptionDialog(null, this.passwordResetView, "Demande d'inscription", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    private void initView(){
        
    }
    
    private void initController(){
        this.passwordResetView.getSubmitButton().addActionListener(e->sendPassword());
    }
    
    private void showErrorMessage(){
        
    }
    
    private void sendPassword(){
        String mail=this.passwordResetView.getEmailTextField().getText();
        if(MainClass.isValidEmail(mail)){
            Adherent adherent=adherentsCrud.getAdherentByEmail(mail);
            if(adherent!=null){
                adherent.setEmail(adherent.getMdp());
            }else{
                Employe employe=employesCrud.getEmployeByEmail(mail);
                if(employe!=null){
                    employe.setEmail(employe.getMdp());
                }else{
                    showErrorMessage();
                }
            }
        }
    }
}
