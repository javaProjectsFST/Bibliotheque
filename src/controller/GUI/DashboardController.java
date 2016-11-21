
package controller.GUI;

import View.DashboardView;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class DashboardController {
    private final DashboardView dashboardView;
    private final Connection connexion;
    private final LivresController livresController;
    private final AdherentsController adherentsController;
    private final EmployesController employesController;

    public DashboardController(Connection connexion) {
        this.dashboardView = new DashboardView();
        this.connexion = connexion;
        this.livresController=new LivresController(dashboardView.getLivresView(), connexion);
        this.adherentsController = new AdherentsController(this.dashboardView.getAdherentsView(), connexion);
        this.employesController=new EmployesController(this.dashboardView.getEmployesView(), connexion);
        
        initView();
        initController();
    }
    
    public DashboardView getDashboardView(){
        return dashboardView;
    }
    
    private void initView(){
        
    }
    
    private void initController(){
        dashboardView.getAddBookPanel().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                dashboardView.getAddBookPanel().setBackground(Color.decode("#b3b2b2"));
            }
            
            @Override
            public void mouseExited(MouseEvent ev){
                dashboardView.getAddBookPanel().setBackground(Color.decode("#CCCCCC"));
            }
            
            @Override
            public void mousePressed(MouseEvent ev){
                dashboardView.getAddBookPanel().setBackground(Color.decode("#939292"));
            }
            
            @Override
            public void mouseReleased(MouseEvent ev){
                dashboardView.getAddBookPanel().setBackground(Color.decode("#b3b2b2"));
            }
        });
    }
}
