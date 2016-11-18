
package controller.GUI;

import View.LoginView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import controller.MainClass;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import model.Adherent;
import model.Employe;

public class LoginController {
    private LoginView loginView;
    private Connection connexion;
    private AdherentsCRUD adherentsCrud;
    private EmployesCRUD employesCrud;

    public LoginController(Connection connexion) {
        this.loginView = new LoginView();
        this.connexion = connexion;
        this.adherentsCrud = new AdherentsCRUD(this.connexion);
        this.employesCrud = new EmployesCRUD(this.connexion);
        
        initView();
        initController();
    }
    
    public LoginView getLoginView(){
        return loginView;
    }
    
    private void initView(){
        reset();
    }
    
    private void initController(){
        loginView.getConnectButton().addActionListener(e -> MainClass.generalController.toNextView());
        
        loginView.getResetButton().addActionListener(e -> reset());
        
        loginView.getLoginTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                loginView.getLoginTextField().setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                loginView.getLoginTextField().setText("Login");
            }
        });
        
        loginView.getMdpTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                loginView.getMdpTextField().setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                loginView.getMdpTextField().setText("Mot de passe");
            }
        });
        
        loginView.addMouseListener(new MouseAdapter(){
             @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                loginView.grabFocus();
            }
        });
    }
    
    private void reset(){
        loginView.getLoginTextField().setText("Login");
        loginView.getMdpTextField().setText("Mot de passe");
    }
    
    public void login(){
        String mdp=loginView.getMdpTextField().getText();
        String login=loginView.getLoginTextField().getText();
        Adherent adherent=adherentsCrud.getAdherentBy(mdp, login);
        if(adherent!=null){
            MainClass.generalController.toNextView();
        }else{
            Employe employe=employesCrud.getEmployeBy(mdp, login);
            if(employe!=null){
                MainClass.generalController.toNextView();
            }
        }
    }
}
