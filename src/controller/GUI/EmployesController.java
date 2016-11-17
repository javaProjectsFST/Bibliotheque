
package controller.GUI;

import View.EmployesView;
import controller.CRUD.EmployesCRUD;
import java.sql.Connection;

public class EmployesController {
    private EmployesView employeView;
    private Connection connexion;
    private EmployesCRUD employesCrud;

    public EmployesController(EmployesView employeView, Connection connexion) {
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
