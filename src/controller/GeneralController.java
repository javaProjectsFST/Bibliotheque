
package controller;

import View.LoginView;
import controller.GUI.DashboardController;
import controller.GUI.LoginController;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GeneralController{
    private Connection connexion;
    private static JPanel container;
    private static CardLayout cardLayout;
    
    public GeneralController(Connection connexion){
        this.connexion=connexion;
        cardLayout=new CardLayout();
        container=new JPanel();
        
        DashboardController dashboardController=new DashboardController(connexion);
        LoginController loginController=new LoginController(connexion);
        
        container.setLayout(cardLayout);
        container.add(loginController.getLoginView());
        container.add(dashboardController.getDashboardView());
        
        JFrame frame=new JFrame("Bibliothéque");
        frame.setPreferredSize(new Dimension(1800,700));
        frame.setMaximumSize(new Dimension(1800, 700));
        frame.setMinimumSize(new Dimension(1800, 700));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setContentPane(container);
        
        frame.setVisible(true);
    }
    
    public static void toNextView(){
        cardLayout.next(container);
    }
}
