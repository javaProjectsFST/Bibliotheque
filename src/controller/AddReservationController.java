
package controller;

import java.awt.Window;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmpruntsCRUD;
import model.CRUD.LivresCRUD;
import model.CRUD.ReservationsCRUD;
import model.entities.Reservation;
import view.AddReservationView;

public class AddReservationController {
    
    private final Connection connexion;
    private final AdherentsCRUD adherentsCrud;
    private final LivresCRUD livresCrud;
    private final ReservationsCRUD reservationsCrud;
    private final AddReservationView addReservationView;
    private final int livreId;
    
    public AddReservationController(Connection connexion, LivresCRUD livresCrud, AdherentsCRUD adherentsCrud, int livreId){
        this.connexion=connexion;
        this.adherentsCrud=adherentsCrud;
        this.livresCrud=livresCrud;
        this.reservationsCrud=new ReservationsCRUD(connexion, livresCrud);
        this.addReservationView=new AddReservationView();
        this.livreId=livreId;
        
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.addReservationView, "Choix Adherent", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    private void initView(){
        ResultSet rs=adherentsCrud.getAllAdherents(false, false);
        if(rs!=null){
            addReservationView.UpdateView(rs);
        }
    }
    
    private void initController(){
        addReservationView.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                addReservationView.getAdherentTable().getSelectionModel().clearSelection();
            }
        });
        addReservationView.getRechercheTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(addReservationView.getRechercheTextField().getText().equals("Recherche")){
                    addReservationView.getRechercheTextField().setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                addReservationView.getAdherentTable().getSelectionModel().clearSelection();
                if(addReservationView.getRechercheTextField().getText().isEmpty()){
                    addReservationView.getRechercheTextField().setText("Recherche");
                    addReservationView.getRechercheTextField().setCaretPosition(0);
                }
                String searched=addReservationView.getRechercheTextField().getText();
                ResultSet rs=null;
                if(searched.equals("Recherche")){
                    rs=adherentsCrud.getAllAdherents(false, false);
                    addReservationView.UpdateView(rs);
                }else{
                    switch((String)addReservationView.getComboBox().getSelectedItem()){
                        case "Login":
                            rs=adherentsCrud.searchAdherentByLogin(searched);
                            addReservationView.UpdateView(rs);
                            break;
                        case "Email":
                            rs=adherentsCrud.searchAdherentByEmail(searched);
                            addReservationView.UpdateView(rs);
                            break;
                        case "Nom":
                            rs=adherentsCrud.searchAdherentByName(searched);
                            addReservationView.UpdateView(rs);
                            break;
                        case "Prenom":
                            rs=adherentsCrud.searchAdherentByLastName(searched);
                            addReservationView.UpdateView(rs);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        addReservationView.getRechercheTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if(addReservationView.getRechercheTextField().getText().equals("Recherche")){
                    addReservationView.getRechercheTextField().setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(addReservationView.getRechercheTextField().getText().isEmpty()){
                    addReservationView.getRechercheTextField().setText("Recherche");
                }
            }
        
        });
        addReservationView.getRechercheTextField().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(addReservationView.getRechercheTextField().getText().equals("Recherche"))
                    addReservationView.getRechercheTextField().setCaretPosition(0);
            }
        });
        
        addReservationView.getAdherentTable().getSelectionModel().addListSelectionListener(e->selectionChanged());
        addReservationView.getReserverButton().addActionListener(e->reserver());
    }
    
    private void selectionChanged(){
        int row=addReservationView.getAdherentTable().getSelectedRow();
        if(row!=-1 && Integer.parseInt(addReservationView.getAdherentTable().getValueAt(row, 4).toString())!=2){
            addReservationView.getReserverButton().setEnabled(true);
        }else{
            addReservationView.getReserverButton().setEnabled(false);
        }
    }
    
    private void reserver(){
        int row=addReservationView.getAdherentTable().getSelectedRow();
        Reservation res=new Reservation(livreId, (String)addReservationView.getAdherentTable().getValueAt(row, 0));
        if(reservationsCrud.addReservation(res)){
            ((Window)SwingUtilities.getWindowAncestor(this.addReservationView)).dispose();
        }
    }

}
