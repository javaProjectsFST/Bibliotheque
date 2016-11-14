
package controller.GUI;

import View.DashboardView;
import java.sql.Connection;

public class DashboardController {
    private DashboardView dashboardView;
    private Connection connexion;
    private LivresController livresController;
    private AdherentsController adherentsController;
    private EmployesController employesController;

    public DashboardController(DashboardView dashboardView,Connection connexion) {
        this.dashboardView = dashboardView;
        this.connexion = connexion;
//        this.livresController = new LivresController(this.dashboardView.getLivresView(), connexion);
//        this.adherentsController = new AdherentsController(this.dashboardView.getAdherentsView(), connexion);
//        this.employesController=new EmployesController(this.dashboardView.getEmployesView(), connexion);
        
        initView();
        initController();
    }
    
    private void initView(){
        
    }
    
    private void initController(){
        
    }
}
