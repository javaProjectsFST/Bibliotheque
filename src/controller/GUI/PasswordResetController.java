
package controller.GUI;

import View.PasswordResetView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import controller.MainClass;
import java.awt.Color;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Adherent;
import model.Employe;

public class PasswordResetController {
    private final PasswordResetView passwordResetView;
    private final AdherentsCRUD adherentsCrud;
    private final EmployesCRUD employesCrud;
    
    public PasswordResetController(Connection connexion){
        this.passwordResetView=new PasswordResetView();
        this.adherentsCrud=new AdherentsCRUD(connexion);
        this.employesCrud=new EmployesCRUD(connexion);
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.passwordResetView, "Compte Oublié", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    private void initView(){
        this.passwordResetView.getSubmitButton().setEnabled(false);
        hideErrorMessage();
    }
    
    private void initController(){
        this.passwordResetView.getSubmitButton().addActionListener(e->sendPassword());
        this.passwordResetView.getEmailTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                String ps=passwordResetView.getEmailTextField().getText();
                if(!MainClass.isValidEmail(ps)){
                    passwordResetView.getSubmitButton().setEnabled(false);
                }else{
                    passwordResetView.getSubmitButton().setEnabled(true);
                }
                hideErrorMessage();
            }
            
        });
    }
    
    private void showNotFoundErrorMessage(){
        this.passwordResetView.getMailNotExistLabel1().setVisible(true);
        this.passwordResetView.getMailNotExistLabel2().setVisible(true);
        ((JPanel)this.passwordResetView.getEmailTextField().getParent()).setBorder(BorderFactory.createLineBorder(Color.red));
    }
    
    private void hideErrorMessage(){
        this.passwordResetView.getMailNotExistLabel1().setVisible(false);
        this.passwordResetView.getMailNotExistLabel2().setVisible(false);
        ((JPanel)passwordResetView.getEmailTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
    }
    
    private void reset(){
        this.passwordResetView.getEmailTextField().setText("");
    }
    
    private void sendPassword(){
        String mail=this.passwordResetView.getEmailTextField().getText();
        Adherent adherent=adherentsCrud.getAdherentByEmail(mail);
        if(adherent!=null){
            adherentsCrud.sendPasswordMail(adherent);
            JOptionPane.showMessageDialog(this.passwordResetView, "Un email contenant vos informations vous à été envoyé.", "Email Enovyé", JOptionPane.PLAIN_MESSAGE);
            ((Window)SwingUtilities.getWindowAncestor(this.passwordResetView)).dispose();
        }else{
            Employe employe=employesCrud.getEmployeByEmail(mail);
            if(employe!=null){
                employesCrud.sendPasswordMail(employe);
                JOptionPane.showMessageDialog(this.passwordResetView, "Un email contenant vos informations vous à été envoyé.", "Email Enovyé", JOptionPane.PLAIN_MESSAGE);
                ((Window)SwingUtilities.getWindowAncestor(this.passwordResetView)).dispose();
            }else{
                showNotFoundErrorMessage();
            }
        }
    }
}
