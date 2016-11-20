
package controller;

import controller.CRUD.AdherentsCRUD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
    public static boolean isValidEmail(String email){
        String pattern="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(email);
        return m.matches();
    }
}
