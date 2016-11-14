
package controller.GUI;

import controller.CRUD.EmployesCRUD;
import java.sql.Connection;
import javax.swing.JPanel;

public class EmployesController {
    private JPanel employeView;
    private Connection connexion;
    private EmployesCRUD employesCrud;

    public EmployesController(JPanel employeView, Connection connexion) {
        this.employeView = employeView;
        this.connexion = connexion;
        this.employesCrud = new EmployesCRUD(connexion);
        
        initView();
        initController();
    }
    
    private void initView(){
        
    }
    
    private void initController(){
        
    }
    
    private void sortBy(){
        
    }
    
    private void searchByFor(){
        
    }
    
    private void addEmploye(){
        
    }
    
    private void deleteEmploye(){
        
    }
    
    private void updateEmploye(){
        
    }
    
    private void refreshTable(){
        
    }
}
