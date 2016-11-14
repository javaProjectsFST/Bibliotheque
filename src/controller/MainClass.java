
package controller;

import View.DashboardView;
import java.awt.Dimension;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JPanel{
    public static Connection connexion;
    
    public static void main(String args[]){
        JFrame frame=new JFrame("Bibliothéque");
        frame.setPreferredSize(new Dimension(1800,700));
        frame.setMaximumSize(new Dimension(1800, 700));
        frame.setMinimumSize(new Dimension(1800, 700));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(new DashboardView());
        
        frame.setVisible(true);
    }
}
