
package controller.GUI;

import View.PasswordResetView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    private boolean isValidEmail(String email){
        String pattern="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(email);
        return m.matches();
    }
    
    private void showErrorMessage(){
        
    }
    
    private void sendPassword(){
        String mail=this.passwordResetView.getEmailTextField().getText();
        if(isValidEmail(mail)){
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
