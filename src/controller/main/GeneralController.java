
package controller.main;

import view.MainFrame;
import controller.DashboardController;
import controller.LoginController;
import java.awt.Component;
import java.sql.Connection;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GeneralController{
    private final Connection connexion;
    private final MainFrame mainFrame;
    private final LoginController loginController;
    private DashboardController dashboardController;
    private int connectedIndex;
    
    public GeneralController(Connection connexion){
        try{
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e){}
        this.connexion=connexion;
        this.loginController=new LoginController(connexion);
        
        connectedIndex=-1;
        this.mainFrame=new MainFrame(loginController.getLoginView());
        loginController.getLoginView().getRootPane().setDefaultButton(loginController.getLoginView().getConnectButton());
    }
    
    public void toNextView(int connectedIndex){
        connectedIndex=connectedIndex;
        dashboardController=new DashboardController(connexion, connectedIndex, this);
        mainFrame.addDashboardView(dashboardController.getDashboardView());
        mainFrame.getCardLayout().next(mainFrame.getContainer());
    }
    
    public void logout(){
        connectedIndex=-1;
        mainFrame.getContainer().remove(1);
    }
    
    public MainFrame getMainFrame(){
        return mainFrame;
    }
    
//    JFrame frame=new JFrame("Bibliothéque");
        
}
