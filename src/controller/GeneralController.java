
package controller;

import View.MainFrame;
import controller.GUI.DashboardController;
import controller.GUI.LoginController;
import java.sql.Connection;

public class GeneralController{
    private Connection connexion;
    private MainFrame mainFrame;
    private LoginController loginController;
    private DashboardController dashboardController;
    
    public GeneralController(Connection connexion){
        this.connexion=connexion;
        this.loginController=new LoginController(connexion);
        this.dashboardController=new DashboardController(connexion);
        
        this.mainFrame=new MainFrame(loginController.getLoginView(), dashboardController.getDashboardView());
    }
    
    public void toNextView(){
       mainFrame.getCardLayout().next(mainFrame.getContainer());
    }
    
//    JFrame frame=new JFrame("Bibliothéque");
        
}
