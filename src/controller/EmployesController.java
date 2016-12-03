
package controller;

import view.EmployesView;
import model.CRUD.EmployesCRUD;
import java.sql.Connection;
import java.sql.ResultSet;

public class EmployesController {
    private final EmployesView employesView;
    private final Connection connexion;
    private final EmployesCRUD employesCrud;

    public EmployesController(EmployesView employesView, Connection connexion) {
        this.employesView = employesView;
        this.connexion = connexion;
        this.employesCrud = new EmployesCRUD(connexion);
        
        initView();
        initController();
    }
    
    private void initView(){
        ResultSet rs=employesCrud.getAllEmployes(false);
        if(rs!=null){
            employesView.UpdateView(rs);
        }
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
