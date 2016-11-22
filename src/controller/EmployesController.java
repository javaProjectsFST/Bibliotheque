
package controller;

import View.EmployesView;
import model.CRUD.EmployesCRUD;
import java.sql.Connection;

public class EmployesController {
    private final EmployesView employeView;
    private final Connection connexion;
    private final EmployesCRUD employesCrud;

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
