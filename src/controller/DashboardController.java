package controller;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import view.DashboardView;
import java.sql.Connection;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import model.CRUD.LivresCRUD;

public class DashboardController {
    private final DashboardView dashboardView;
    private final Connection connexion;
    private final LivresController livresController;
    private final AdherentsController adherentsController;
    private final EmployesController employesController;
    public final LivresCRUD livresCrud;
    private final int connectedIndex;
    private JPopupMenu m;
    
    
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
        m=new JPopupMenu("yoo");
        m.setPreferredSize(new Dimension(50,200));
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
        dashboardView.getDeleteBookButton().addActionListener(e->livresController.deleteBook());
        dashboardView.getReservationButton().addActionListener(e->showMenu(dashboardView.getReservationButton()));
//        dashboardView.getReservationButton().addMouseListener(new MouseAdapter(){
//            @Override
//            public void mousePressed(MouseEvent ev){
//                super.mousePressed(ev);
//                showMenu(dashboardView.getReservationButton());
//            }
//            
//            @Override
//            public void mouseReleased(MouseEvent ev){
//                super.mouseReleased(ev);
//                showMenu(dashboardView.getReservationButton());
//            }
//        });
    }
    
    private void showMenu(JComponent c){
        int x=c.getX();
        int y=c.getY();
        m.show(c, x, y);
    }
}
