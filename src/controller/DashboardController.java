package controller;

import view.DashboardView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JTable;
import model.CRUD.LivresCRUD;

public class DashboardController {
    private final DashboardView dashboardView;
    private final Connection connexion;
    private final LivresController livresController;
    private final AdherentsController adherentsController;
    private final EmployesController employesController;
    public final LivresCRUD livresCrud;
    private final int connectedIndex;
    
    
    public DashboardController(Connection connexion, int connectedIndex) {
        this.dashboardView = new DashboardView();
        this.connexion = connexion;
        this.connectedIndex=connectedIndex;
        
        this.livresController=new LivresController(dashboardView.getLivresView(), connexion);
        this.adherentsController = new AdherentsController(this.dashboardView.getAdherentsView(), connexion);
        this.employesController=new EmployesController(this.dashboardView.getEmployesView(), connexion);
        
        this.livresCrud=new LivresCRUD(connexion, this.livresController.getLivreView());
        initView();
        initController();
    }
    
    public DashboardView getDashboardView(){
        return dashboardView;
    }
    
    private void initView(){
        switch(connectedIndex){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }
    
    private void initController(){
        dashboardView.getAddBookButton().addActionListener(e->livresController.addBook());
        dashboardView.getAddBookButton().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
            }
            
            @Override
            public void mouseExited(MouseEvent ev){
            }
        });
        dashboardView.getDeleteBookButton().addActionListener(e->livresController.deleteBook());
    }
}
