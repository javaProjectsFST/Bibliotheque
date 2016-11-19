
package controller;

import controller.CRUD.AdherentsCRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JPanel;

public class MainClass extends JPanel{
    public static Connection connexion;
    public static GeneralController generalController;
    
    static Connection makeConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Connection to localhost:3306
//            String url = "jdbc:mysql://localhost:3306/bibliotheque";
//            String user = "root";
//            String mdp="";
            
            //Connection to hosted database
            String url = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8145007";
            String user = "sql8145007";
            String mdp="xysgX4HhML";
            
            connexion = DriverManager.getConnection(url, user, mdp);
            return connexion;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String args[]){
        Connection connexion;
        connexion=makeConnection();
        if(connexion!=null){
            generalController=new GeneralController(connexion);
        }
    }
}
