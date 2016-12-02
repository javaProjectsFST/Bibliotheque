package controller;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.DashboardView;
import java.sql.Connection;
import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmpruntsCRUD;
import model.CRUD.LivresCRUD;
import model.CRUD.ReservationsCRUD;
import model.entities.Emprunt;
import model.entities.Reservation;

public class DashboardController {
    private final DashboardView dashboardView;
    private final Connection connexion;
    private final LivresController livresController;
    private final AdherentsController adherentsController;
    private final EmployesController employesController;
    public final LivresCRUD livresCrud;
    public final AdherentsCRUD adherentsCrud;
//    public final EmployesCRUD employesCrud;
    private final int connectedIndex;
    private final EmpruntsCRUD empruntsCrud;
    private final ReservationsCRUD reservationsCrud;
    private JPopupMenu m;
    
    
    public DashboardController(Connection connexion, int connectedIndex) {
        this.dashboardView = new DashboardView();
        this.connexion = connexion;
        this.connectedIndex=connectedIndex;
        
        this.livresController=new LivresController(dashboardView.getLivresView(), dashboardView.getAdherentsView(), connexion);
        this.adherentsController = new AdherentsController(this.dashboardView.getAdherentsView(), connexion);
        this.employesController=new EmployesController(this.dashboardView.getEmployesView(), connexion);
        
        this.livresCrud=new LivresCRUD(connexion, this.livresController.getLivreView());
        this.adherentsCrud=new AdherentsCRUD(connexion, this.adherentsController.getAdherentView());
        this.empruntsCrud=new EmpruntsCRUD(connexion, this.livresCrud);
        this.reservationsCrud=new ReservationsCRUD(connexion, livresCrud);
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
        dashboardView.getMakeReservationButton().addActionListener(e->reservationClicked());
        dashboardView.getEmpruntButton().addActionListener(e->empruntClicked());
    }
    
    private void reservationClicked(){
        JTable table=dashboardView.getLivresView().getLivresTable();
        int[] rows=table.getSelectedRows();
        if(rows.length==1){
            if(table.getValueAt(rows[0], 7)==null){
                new AddReservationController(connexion, livresCrud, adherentsCrud, (int)table.getValueAt(rows[0], 0));
            }else{
                reservationsCrud.deleteReservationByLivre(Integer.parseInt(table.getValueAt(rows[0], 0).toString()));
            }
        }else{
            for(int row : rows){
                reservationsCrud.deleteReservationByLivre(Integer.parseInt(table.getValueAt(row, 0).toString()));
            }
            reservationsCrud.UpdateView();
        }
    }
    
    private void empruntClicked(){
        JTable table=dashboardView.getLivresView().getLivresTable();
        int[] rows=table.getSelectedRows();
        if(rows.length == 1){
            if(table.getValueAt(rows[0], 5)==null && table.getValueAt(rows[0], 7)==null){
                new AddEmpruntController(connexion, livresCrud, adherentsCrud, (int)table.getValueAt(rows[0],0));
            }else if(table.getValueAt(rows[0], 5)==null && table.getValueAt(rows[0], 7)!=null){
                Reservation rs=reservationsCrud.getReservationByLivre(Integer.parseInt(table.getValueAt(rows[0], 0).toString()));
                String loginAdherent=rs.getLoginAdherentRes();
                int choix=dashboardView.showEmpruntMessage(loginAdherent);
                if(choix==0){
                    reservationsCrud.deleteReservationByLivre(Integer.parseInt(table.getValueAt(rows[0], 0).toString()));
                    Emprunt emp=new Emprunt(Integer.parseInt(table.getValueAt(rows[0], 0).toString()), loginAdherent);
                    empruntsCrud.addEmprent(emp);
                }
            }else{
                empruntsCrud.deleteEmprentByLivre(Integer.parseInt(table.getValueAt(rows[0], 0).toString()));
                empruntsCrud.updateView();
            }
        }else{
            for(int row : rows){
                empruntsCrud.deleteEmprentByLivre(Integer.parseInt(table.getValueAt(row, 0).toString()));
            }
            empruntsCrud.updateView();
        }
    }
    
    private void selectionChanged(){
        JTable table=dashboardView.getLivresView().getLivresTable();
        int[] rows=dashboardView.getLivresView().getLivresTable().getSelectedRows();
        if(rows.length == 1){
            if(table.getValueAt(rows[0], 5)!=null){
                dashboardView.setCancelEmpruntIcon();
                dashboardView.getEmpruntButton().setEnabled(true);
                
                dashboardView.setReserverIcon();
                dashboardView.getMakeReservationButton().setEnabled(false);
                dashboardView.getDeleteBookButton().setEnabled(false);
            }else if(table.getValueAt(rows[0], 7)!=null){
                dashboardView.setEmpruntIcon();
                dashboardView.getEmpruntButton().setEnabled(true);
                
                dashboardView.setCanceReserveIcon();
                dashboardView.getMakeReservationButton().setEnabled(true);
                dashboardView.getDeleteBookButton().setEnabled(false);
            }else{
                dashboardView.setEmpruntIcon();
                dashboardView.getEmpruntButton().setEnabled(true);
                
                dashboardView.setReserverIcon();
                dashboardView.getMakeReservationButton().setEnabled(true);
                
                dashboardView.getDeleteBookButton().setEnabled(true);
            }
        }else if(rows.length > 1){
            if(table.getValueAt(rows[0], 5)!=null){
                for(int row : rows){
                    if(table.getValueAt(row, 5)==null){
                        disableLivreButtons();
                        return;
                    }
                }
                dashboardView.setCancelEmpruntIcon();
                dashboardView.getEmpruntButton().setEnabled(true);
                
                dashboardView.setReserverIcon();
                dashboardView.getMakeReservationButton().setEnabled(false);
                dashboardView.getDeleteBookButton().setEnabled(false);
            }else if(table.getValueAt(rows[0], 7)!=null){
                for(int row : rows){
                    if(table.getValueAt(row, 7)==null){
                        disableLivreButtons();
                        return;
                    }
                }
                dashboardView.setEmpruntIcon();
                dashboardView.getEmpruntButton().setEnabled(false);
                
                dashboardView.setCanceReserveIcon();
                dashboardView.getMakeReservationButton().setEnabled(true);
                dashboardView.getDeleteBookButton().setEnabled(false);
            }else{
                dashboardView.setEmpruntIcon();
                dashboardView.getEmpruntButton().setEnabled(false);
                
                dashboardView.setReserverIcon();
                dashboardView.getMakeReservationButton().setEnabled(false);
                dashboardView.getDeleteBookButton().setEnabled(true);
            }
        }else{
            disableLivreButtons();
        }
    }
    
    private void disableLivreButtons(){
        dashboardView.setReserverIcon();
        dashboardView.setReserverIcon();
        dashboardView.getEmpruntButton().setEnabled(false);
        dashboardView.getMakeReservationButton().setEnabled(false);
        dashboardView.getDeleteBookButton().setEnabled(false);
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
