package controller;

import controller.main.GeneralController;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.DashboardView;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmployesCRUD;
import model.CRUD.EmpruntsCRUD;
import model.CRUD.LivresCRUD;
import model.CRUD.ReservationsCRUD;
import model.entities.Adherent;
import model.entities.Emprunt;
import model.entities.Livre;
import model.entities.Reservation;

public class DashboardController {
    private final DashboardView dashboardView;
    private final Connection connexion;
    private final LivresController livresController;
    private final AdherentsController adherentsController;
    private final EmployesController employesController;
    public final LivresCRUD livresCrud;
    public final AdherentsCRUD adherentsCrud;
    public final EmployesCRUD employesCrud;
    private final int connectedIndex;
    private final EmpruntsCRUD empruntsCrud;
    private final ReservationsCRUD reservationsCrud;
    private final GeneralController general;
    
    
    public DashboardController(Connection connexion, int connectedIndex, GeneralController general) {
        this.dashboardView = new DashboardView();
        this.connexion = connexion;
        this.connectedIndex=connectedIndex;
        this.general=general;
        
        this.livresController=new LivresController(dashboardView.getLivresView(), dashboardView.getAdherentsView(), connexion);
        this.adherentsController = new AdherentsController(this.dashboardView.getAdherentsView(), connexion);
        this.employesController=new EmployesController(this.dashboardView.getEmployesView(), connexion);
        
        this.livresCrud=new LivresCRUD(connexion, this.livresController.getLivreView());
        this.adherentsCrud=new AdherentsCRUD(connexion, this.adherentsController.getAdherentView());
        this.empruntsCrud=new EmpruntsCRUD(connexion, this.livresCrud);
        this.reservationsCrud=new ReservationsCRUD(connexion, livresCrud);
        this.employesCrud=new EmployesCRUD(connexion, dashboardView.getEmployesView());
        initView();
        initController();
    }
    
    public DashboardView getDashboardView(){
        return dashboardView;
    }
    
    public void updateMenu(){
        dashboardView.getToutNumber().setText("("+String.valueOf(livresCrud.getLivresCount())+")");
        dashboardView.getEmpruntesNumber().setText("("+String.valueOf(empruntsCrud.getEmpruntsCount())+")");
        dashboardView.getDateLimiteNumber().setText("("+String.valueOf(empruntsCrud.getEmpruntsLimCount())+")");
        dashboardView.getReservesNumber().setText("("+String.valueOf(reservationsCrud.getReservationsCount())+")");
    }
    
    private void initView(){
        updateMenu();
        dashboardView.setComboForLivre();
        dashboardView.livreTabVisible(connectedIndex);
        switch(connectedIndex){
            case 1:
                break;
            case 2:
                dashboardView.getTabbedPane().remove(2);
                dashboardView.getTabbedPane().remove(1);
                break;
            case 3:
                dashboardView.getTabbedPane().remove(2);
                dashboardView.getTabbedPane().remove(1);
                break;
            default:
                break;
        }
    }
    
    private void rechercheTextFieldLoosFocus(){
        dashboardView.getRechercheTextField().setFocusable(false);
        dashboardView.getRechercheTextField().setFocusable(true);
    }
    
    private void initController(){
        dashboardView.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                livresController.looseTableFocus();
                rechercheTextFieldLoosFocus();
            }
        });
        dashboardView.getTabbedPane().addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                livresController.looseTableFocus();
                rechercheTextFieldLoosFocus();
            }
        });
        dashboardView.getTabbedPane().addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                int index=dashboardView.getTabbedPane().getSelectedIndex();
                switch(index){
                    case 0:
                        dashboardView.setComboForLivre();
                        dashboardView.livreTabVisible(connectedIndex);
                        break;
                    case 1:
                        dashboardView.setComboForAdherent();
                        dashboardView.adherentTabVisible(connectedIndex);
                        break;
                    case 2:
                        dashboardView.setComboForEmploye();
                        dashboardView.employeTabVisible(connectedIndex);
                        break;
                    default:
                        break;
                }
            }
        
        });
        dashboardView.getAddBookButton().addActionListener(e->addBookClicked());
        dashboardView.getDeleteBookButton().addActionListener(e->deleteBookClicked());
        dashboardView.getLivresView().getLivresTable().getSelectionModel().addListSelectionListener(e -> selectionChanged());
        dashboardView.getAdherentsView().getAdherentsTable().getSelectionModel().addListSelectionListener(e -> adherentTableSelectionChanged());
        dashboardView.getEmployesView().getEmployessTable().getSelectionModel().addListSelectionListener(e->employeTableSelectionChanged());
        dashboardView.getMakeReservationButton().addActionListener(e->reservationClicked());
        dashboardView.getEmpruntButton().addActionListener(e->empruntClicked());
        
        dashboardView.getRechercheTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if(dashboardView.getRechercheTextField().getText().equals("Recherche")){
                    dashboardView.getRechercheTextField().setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(dashboardView.getRechercheTextField().getText().isEmpty())
                    dashboardView.getRechercheTextField().setText("Recherche");
            }
        });
        dashboardView.getRechercheTextField().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(dashboardView.getRechercheTextField().getText().equals("Recherche"))
                    dashboardView.getRechercheTextField().setCaretPosition(0);
            }
        });
        dashboardView.getRechercheTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(dashboardView.getRechercheTextField().getText().equals("Recherche")){
                    dashboardView.getRechercheTextField().setText("");
                }
                ((JPanel)dashboardView.getRechercheTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                dashboardView.getLivresView().looseTableFocus();
                if(dashboardView.getRechercheTextField().getText().isEmpty()){
                    dashboardView.getRechercheTextField().setText("Recherche");
                    dashboardView.getRechercheTextField().setCaretPosition(0);
                }
                String searched;
                if(dashboardView.getRechercheTextField().getText().equals("Recherche"))
                    searched="";
                else
                    searched=dashboardView.getRechercheTextField().getText();
                if(dashboardView.getTabbedPane().getSelectedIndex()==0){
                    if(dashboardView.getSelectedIndex()==1)
                        livresController.searchByFor(dashboardView.getComboBox().getSelectedIndex(), searched);
                    else if(dashboardView.getSelectedIndex()==2)
                        livresController.searchByForInEmprunt(dashboardView.getComboBox().getSelectedIndex(), searched);
                    else if(dashboardView.getSelectedIndex()==3)
                        livresController.searchByForInDateLim(dashboardView.getComboBox().getSelectedIndex(), searched);
                    else if(dashboardView.getSelectedIndex()==4)
                        livresController.searchByForInReservation(dashboardView.getComboBox().getSelectedIndex(), searched);
                }else if(dashboardView.getTabbedPane().getSelectedIndex()==1){
                    int i=dashboardView.getComboBox().getSelectedIndex();
                    if(i==0){
                        ResultSet rs=adherentsCrud.searchAdherentByLogin(searched);
                        dashboardView.getAdherentsView().UpdateView(rs);
                    }else if(i==1){
                        ResultSet rs=adherentsCrud.searchAdherentByLastName(searched);
                        dashboardView.getAdherentsView().UpdateView(rs);
                    }else if(i==2){
                        ResultSet rs=adherentsCrud.searchAdherentByName(searched);
                        dashboardView.getAdherentsView().UpdateView(rs);
                    }
                }else if(dashboardView.getTabbedPane().getSelectedIndex()==2){
                    int i=dashboardView.getComboBox().getSelectedIndex();
                    if(i==0){
                        ResultSet rs=employesCrud.searchEmployeByLogin(searched);
                        dashboardView.getEmployesView().UpdateView(rs);
                    }else if(i==1){
                        ResultSet rs=employesCrud.searchEmployeByName(searched);
                        dashboardView.getEmployesView().UpdateView(rs);
                    }else if(i==2){
                        ResultSet rs=employesCrud.searchEmployeByLastName(searched);
                        dashboardView.getEmployesView().UpdateView(rs);
                    }
                }
            }
        });
        
        dashboardView.getToutPanel().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                super.mouseEntered(ev);
                dashboardView.getToutPanel().setBackground(dashboardView.getHoveredColor());
            }
            
            @Override
            public void mouseExited(MouseEvent ev){
                super.mouseExited(ev);
                dashboardView.getToutPanel().setBackground(dashboardView.getToutPanelColor());
            }
            
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                dashboardView.getToutPanel().setBackground(dashboardView.getClickedColor());
            }
            
            @Override
            public void mouseReleased(MouseEvent ev){
                super.mouseReleased(ev);
                dashboardView.unClickAll();
                dashboardView.toutPanelSelected();
                livresController.getLivreView().UpdateView(livresCrud.getAllLivres(true));
            }
        });
        dashboardView.getEmpruntesPanel().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                super.mouseEntered(ev);
                dashboardView.getEmpruntesPanel().setBackground(dashboardView.getHoveredColor());
            }
            
            @Override
            public void mouseExited(MouseEvent ev){
                super.mouseExited(ev);
                dashboardView.getEmpruntesPanel().setBackground(dashboardView.getEmpruntePanelColor());
            }
            
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                dashboardView.getEmpruntesPanel().setBackground(dashboardView.getClickedColor());
            }
            
            @Override
            public void mouseReleased(MouseEvent ev){
                super.mouseReleased(ev);
                dashboardView.unClickAll();
                dashboardView.emprentePanelSelected();
                livresController.getLivreView().UpdateView(livresCrud.getAllLivresInEmprunt(true));
            }
        });
        dashboardView.getDateLimitePanel().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                super.mouseEntered(ev);
                dashboardView.getDateLimitePanel().setBackground(dashboardView.getHoveredColor());
            }
            
            @Override
            public void mouseExited(MouseEvent ev){
                super.mouseExited(ev);
                dashboardView.getDateLimitePanel().setBackground(dashboardView.getDateLimitePanelColor());
            }
            
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                dashboardView.getDateLimitePanel().setBackground(dashboardView.getClickedColor());
            }
            
            @Override
            public void mouseReleased(MouseEvent ev){
                super.mouseReleased(ev);
                dashboardView.unClickAll();
                dashboardView.dateLimitePanelSelected();
                livresController.getLivreView().UpdateView(livresCrud.getAllLivresInDateLim(true));
            }
        });
        dashboardView.getReservesPanel().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent ev){
                super.mouseEntered(ev);
                dashboardView.getReservesPanel().setBackground(dashboardView.getHoveredColor());
            }
            
            @Override
            public void mouseExited(MouseEvent ev){
                super.mouseExited(ev);
                dashboardView.getReservesPanel().setBackground(dashboardView.getReservesPanelColor());
            }
            
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                dashboardView.getReservesPanel().setBackground(dashboardView.getClickedColor());
            }
            
            @Override
            public void mouseReleased(MouseEvent ev){
                super.mouseReleased(ev);
                dashboardView.unClickAll();
                dashboardView.reservesPanelSelected();
                livresController.getLivreView().UpdateView(livresCrud.getAllLivresInReservation(true));
            }
        });
        
        dashboardView.getLogoutButton().addActionListener(e->logout());
        dashboardView.getEmailButton().addActionListener(e->sendEmail());
        dashboardView.getDetailsButton().addActionListener(e->detailsClicked());
        dashboardView.getRemoveAdherentButton().addActionListener(e->removeAdherentClicked());
        dashboardView.getAddAdherentButton().addActionListener(e->new AddAdherentController(connexion, dashboardView.getAdherentsView()));
        dashboardView.getRemoveEmployeButton().addActionListener(e->removeEmployeClicked());
        dashboardView.getAddEmployeButton().addActionListener(e->new AddEmployeController(connexion, dashboardView.getEmployesView()));
    }
    
    private void removeEmployeClicked(){
        JTable table=dashboardView.getEmployesView().getEmployessTable();
        int[] rows=table.getSelectedRows();
        for(int row : rows){
            employesCrud.deleteEmployeBy(table.getValueAt(row, 0).toString());
        }
        employesCrud.updateView();
    }
    
    private void removeAdherentClicked(){
        JTable table=dashboardView.getAdherentsView().getAdherentsTable();
        int[] rows=table.getSelectedRows();
        for(int row : rows){
            adherentsCrud.deleteAdherentBy(table.getValueAt(row, 0).toString());
        }
        adherentsCrud.updateView();
    }
    
    private void employeTableSelectionChanged(){
        int row=dashboardView.getEmployesView().getEmployessTable().getSelectedRow();
        if(row!=-1){
            dashboardView.getRemoveEmployeButton().setEnabled(true);
        }else{
            dashboardView.getRemoveEmployeButton().setEnabled(false);
        }
    }
    
    private void adherentTableSelectionChanged(){
        int row=dashboardView.getAdherentsView().getAdherentsTable().getSelectedRow();
        if(row!=-1)
            dashboardView.getRemoveAdherentButton().setEnabled(true);
        else
            dashboardView.getRemoveAdherentButton().setEnabled(false);
    }
    
    private void detailsClicked(){
        int row=dashboardView.getLivresView().getLivresTable().getSelectedRow();
        new LivreDetailsController(connexion, livresCrud, Integer.parseInt(dashboardView.getLivresView().getLivresTable().getValueAt(row, 0).toString()));
    }
    
    private void sendEmail(){
        JTable table=dashboardView.getLivresView().getLivresTable();
        Livre livre=livresCrud.getLivreBy(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
        Emprunt emp=empruntsCrud.getEmprentByLivre(livre.getId());
        Adherent adherent=adherentsCrud.getAdherentBy(emp.getLoginAdherentEmp());
        if(adherentsCrud.sendAvetMail(livre, adherent, emp))
            JOptionPane.showMessageDialog(dashboardView, "Un email d'avertissement à été envoyer à l'adherent concerné");
    }
    
    public void updateView(){
        initView();
    }
    
    private void logout(){
        general.logout();
    }
    
    private void addBookClicked(){
        livresController.addBook();
        updateMenu();
    }
    
    private void deleteBookClicked(){
        livresController.deleteBook();
        updateMenu();
    }
    
    private void reservationClicked(){
        JTable table=dashboardView.getLivresView().getLivresTable();
        int[] rows=table.getSelectedRows();
        if(rows.length==1){
            if(table.getValueAt(rows[0], 7)==null){
                new AddReservationController(connexion, livresCrud, adherentsCrud, (int)table.getValueAt(rows[0], 0));
            }else{
                reservationsCrud.deleteReservationByLivre(Integer.parseInt(table.getValueAt(rows[0], 0).toString()));
                reservationsCrud.UpdateView();
            }
        }else{
            for(int row : rows){
                reservationsCrud.deleteReservationByLivre(Integer.parseInt(table.getValueAt(row, 0).toString()));
            }
            reservationsCrud.UpdateView();
        }
        updateMenu();
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
        updateMenu();
    }
    
    private void selectionChanged(){
        JTable table=dashboardView.getLivresView().getLivresTable();
        int[] rows=dashboardView.getLivresView().getLivresTable().getSelectedRows();
        try {
            if(rows.length == 1){
                dashboardView.getDetailsButton().setEnabled(true);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                
                Date dateLim=null;
                Date date=null;
                if(table.getValueAt(rows[0], 6)!=null){
                    java.util.Date parsed = format.parse(table.getValueAt(rows[0], 6).toString());
                    dateLim= new Date(parsed.getTime());
                    Calendar calendar = Calendar.getInstance();
                    date=new Date(calendar.getTime().getTime());
                }
                if(table.getValueAt(rows[0], 5)!=null && date!=null && dateLim!=null && date.after(dateLim)){
                    dashboardView.getEmailButton().setEnabled(true);
                    
                    dashboardView.setCancelEmpruntIcon();
                    dashboardView.getEmpruntButton().setEnabled(true);
                    dashboardView.setReserverIcon();
                    dashboardView.getMakeReservationButton().setEnabled(false);
                    dashboardView.getDeleteBookButton().setEnabled(false);
                }else if(table.getValueAt(rows[0], 5)!=null){
                    dashboardView.setCancelEmpruntIcon();
                    dashboardView.getEmpruntButton().setEnabled(true);

                    dashboardView.setReserverIcon();
                    dashboardView.getMakeReservationButton().setEnabled(false);
                    dashboardView.getDeleteBookButton().setEnabled(false);
                    dashboardView.getEmailButton().setEnabled(false);
                }else if(table.getValueAt(rows[0], 7)!=null){
                    dashboardView.setEmpruntIcon();
                    dashboardView.getEmpruntButton().setEnabled(true);

                    dashboardView.setCanceReserveIcon();
                    dashboardView.getMakeReservationButton().setEnabled(true);
                    dashboardView.getDeleteBookButton().setEnabled(false);
                    dashboardView.getEmailButton().setEnabled(false);
                }else{
                    dashboardView.setEmpruntIcon();
                    dashboardView.getEmpruntButton().setEnabled(true);

                    dashboardView.setReserverIcon();
                    dashboardView.getMakeReservationButton().setEnabled(true);

                    dashboardView.getDeleteBookButton().setEnabled(true);
                    dashboardView.getEmailButton().setEnabled(false);
                }
            }else if(rows.length > 1){
                dashboardView.getDetailsButton().setEnabled(false);
                dashboardView.getEmailButton().setEnabled(false);
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
        } catch (java.text.ParseException ex) {
                ex.printStackTrace();
        }
    }
    
    private void disableLivreButtons(){
        dashboardView.setReserverIcon();
        dashboardView.setEmpruntIcon();
        dashboardView.getEmpruntButton().setEnabled(false);
        dashboardView.getMakeReservationButton().setEnabled(false);
        dashboardView.getDeleteBookButton().setEnabled(false);
        dashboardView.getEmailButton().setEnabled(false);
        dashboardView.getDetailsButton().setEnabled(false);
    }
}
