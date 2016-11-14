
package controller.CRUD;

import java.sql.Connection;
import java.util.Vector;
import model.Employe;

public class EmployesCRUD {
    private Connection connexion;    

    public EmployesCRUD(Connection connexion) {
        this.connexion = connexion;
    }
    
    public boolean addEmploye(Employe employe){
        return true;
    }
    
    public Employe getEmployeBy(int id){
        return null;
    }
    
    public Employe deleteEmployeBy(int id){
        return null;
    }
    
    public boolean updateEmploye(int id, Employe employe){
        return true;
    }
    
    public Vector<Employe> getAllEmployes(){
        return null;
    }
}
