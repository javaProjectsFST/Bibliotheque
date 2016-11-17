
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JPanel;

public class MainClass extends JPanel{
    public static Connection connexion;
    
    static Connection makeConnection(){
        try{
                Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/bibliotheque";
            String user = "root";

            connexion = DriverManager.getConnection(url, user, "");
            return connexion;
        }catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
    
    public static void main(String args[]){
        Connection connexion;
        connexion=makeConnection();
        if(connexion!=null){
            new GeneralController(connexion);
        }
    }
}
