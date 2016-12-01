package controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        m.setPreferredSize(new Dimension(200,70));
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
        dashboardView.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                livresController.looseTableFocus();
            }
        });
        dashboardView.getTabbedPane().addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                livresController.looseTableFocus();
            }
        });
        dashboardView.getAddBookButton().addActionListener(e->livresController.addBook());
        dashboardView.getDeleteBookButton().addActionListener(e->livresController.deleteBook());
        dashboardView.getLivresView().getLivresTable().getSelectionModel().addListSelectionListener(e -> selectionChanged());
        dashboardView.getMakeReservationButton().addActionListener(e->livresController.reserveBook());
        dashboardView.getMakeReservationButton().addActionListener(e->reservationClicked());
    }
    
    private void reservationClicked(){
        int row=dashboardView.getLivresView().getLivresTable().getSelectedRow();
        if(!(dashboardView.getLivresView().getLivresTable().getValueAt(row, 6)==null) && !(dashboardView.getLivresView().getLivresTable().getValueAt(row, 6).equals(""))){
            
        }else{
            
        }
    }
    
    private void empruntClicked(){
        if(dashboardView.getLivresView().getLivresTable().getSelectedRowCount()==1){
            int row=dashboardView.getLivresView().getLivresTable().getSelectedRow();
            if(!(dashboardView.getLivresView().getLivresTable().getValueAt(row, 4)==null)){
                //emprunté ici
            }else{
                //annuler l'emprunt ici
            }
        }else{
            int[] rows=dashboardView.getLivresView().getLivresTable().getSelectedRows();
            if(dashboardView.getLivresView().getLivresTable().getValueAt(rows[0], 4)==null){
                return;
            }else{
                for(int i=rows.length-1; i>0; i--){
                    if(dashboardView.getLivresView().getLivresTable().getValueAt(rows[i], 4)==null)
                        return;
                }
                //Annuler l'emprunt ici
            }
        }
    }
    
    private void selectionChanged(){
        int row=dashboardView.getLivresView().getLivresTable().getSelectedRow();
        if(row!=-1){
            dashboardView.getDeleteBookButton().setEnabled(true);
            dashboardView.getMakeReservationButton().setEnabled(true);
            dashboardView.getEmpruntButton().setEnabled(true);
        }else{
            dashboardView.getDeleteBookButton().setEnabled(false);
            dashboardView.getMakeReservationButton().setEnabled(false);
            dashboardView.getEmpruntButton().setEnabled(false);
        }
    }
    
    private int i=0;
    private void showMenu(JComponent c){
        if(i==0){
            Point p=c.getLocation();
            m.show(c, p.x-313, p.y+c.getHeight()-2);
            i=1;
        }else{
            m.setVisible(false);
            i=0;
        }
    }
}
