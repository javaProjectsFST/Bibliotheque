
package View;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
    private CardLayout cardLayout;
    private JPanel container;
    
    public MainFrame(LoginView loginView, DashboardView dashboardView) {
        cardLayout=new CardLayout();
        container=new JPanel(cardLayout);
        
        container.add(loginView);
        container.add(dashboardView);
        
        this.setContentPane(container);
        this.setPreferredSize(new Dimension(1200,700));
        this.setMaximumSize(new Dimension(1200, 700));
        this.setMinimumSize(new Dimension(1200, 700));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setContentPane(container);
        
        this.setVisible(true);
    }
    
    public CardLayout getCardLayout(){
        return cardLayout;
    }
    
    public JPanel getContainer(){
        return container;
    }
}
