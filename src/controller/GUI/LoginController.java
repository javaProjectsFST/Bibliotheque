
package controller.GUI;

import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import java.sql.Connection;
import javax.swing.JPanel;

public class LoginController {
    private JPanel loginView;
    private Connection connexion;
    private AdherentsCRUD adherentsCrud;
    private EmployesCRUD employesCrud;

    public LoginController(JPanel loginView, Connection connexion) {
        this.loginView = loginView;
        this.connexion = connexion;
        this.adherentsCrud = new AdherentsCRUD(this.connexion);
        this.employesCrud = new EmployesCRUD(this.connexion);
        
        initView();
        initController();
    }
    
    private void initView(){
        
    }
    
    private void initController(){
        
    }
    
    public void login(){
        
    }
}
