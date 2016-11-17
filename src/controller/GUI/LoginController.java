
package controller.GUI;

import View.LoginView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import controller.GeneralController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

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
        
    }
    
    private void initController(){
        loginView.getNextButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                GeneralController.toNextView();
            }
        });
    }
    
    public void login(){
        
    }
}
