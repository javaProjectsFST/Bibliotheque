
package controller;

import View.MainFrame;
import controller.GUI.DashboardController;
import controller.GUI.LoginController;
import java.sql.Connection;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GeneralController{
    private Connection connexion;
    private MainFrame mainFrame;
    private LoginController loginController;
    private DashboardController dashboardController;
    
    public GeneralController(Connection connexion){
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){}
        this.connexion=connexion;
        this.loginController=new LoginController(connexion);
        this.dashboardController=new DashboardController(connexion);
        
        this.mainFrame=new MainFrame(loginController.getLoginView(), dashboardController.getDashboardView());
        loginController.getLoginView().requestFocusInWindow();
        loginController.getLoginView().getRootPane().setDefaultButton(loginController.getLoginView().getConnectButton());
    }
    
    public void toNextView(){
       mainFrame.getCardLayout().next(mainFrame.getContainer());
    }
    
//    JFrame frame=new JFrame("Bibliothéque");
        
}
