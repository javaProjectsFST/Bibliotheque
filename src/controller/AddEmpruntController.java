
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
import model.entities.Emprunt;
import view.AddEmpruntView;

public class AddEmpruntController {
    
    private final Connection connexion;
    private final AdherentsCRUD adherentsCrud;
    private final LivresCRUD livresCrud;
    private final EmpruntsCRUD empruntsCrud;
    private final AddEmpruntView addEmpruntLivreView;
    private final int livreId;
    
    public AddEmpruntController(Connection connexion, LivresCRUD livresCrud, AdherentsCRUD adherentsCrud, int livreId){
        this.connexion=connexion;
        this.adherentsCrud=adherentsCrud;
        this.livresCrud=livresCrud;
        this.empruntsCrud=new EmpruntsCRUD(this.connexion, livresCrud);
        this.addEmpruntLivreView=new AddEmpruntView();
        this.livreId=livreId;
        
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.addEmpruntLivreView, "Choix Adherent", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    private void initView(){
        ResultSet rs=adherentsCrud.getAllAdherents(false, true);
        if(rs!=null){
            addEmpruntLivreView.UpdateView(rs);
        }
    }
    
    private void initController(){
        addEmpruntLivreView.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                addEmpruntLivreView.getAdherentTable().getSelectionModel().clearSelection();
            }
        });
        addEmpruntLivreView.getRechercheTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(addEmpruntLivreView.getRechercheTextField().getText().equals("Recherche")){
                    addEmpruntLivreView.getRechercheTextField().setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                addEmpruntLivreView.getAdherentTable().getSelectionModel().clearSelection();
                if(addEmpruntLivreView.getRechercheTextField().getText().isEmpty()){
                    addEmpruntLivreView.getRechercheTextField().setText("Recherche");
                    addEmpruntLivreView.getRechercheTextField().setCaretPosition(0);
                }
                String searched=addEmpruntLivreView.getRechercheTextField().getText();
                ResultSet rs=null;
                if(searched.equals("Recherche")){
                    rs=adherentsCrud.getAllAdherents(false, true);
                    addEmpruntLivreView.UpdateView(rs);
                }else{
                    switch((String)addEmpruntLivreView.getComboBox().getSelectedItem()){
                        case "Login":
                            rs=adherentsCrud.searchAdherentByLogin(searched);
                            addEmpruntLivreView.UpdateView(rs);
                            break;
                        case "Email":
                            rs=adherentsCrud.searchAdherentByEmail(searched);
                            addEmpruntLivreView.UpdateView(rs);
                            break;
                        case "Nom":
                            rs=adherentsCrud.searchAdherentByName(searched);
                            addEmpruntLivreView.UpdateView(rs);
                            break;
                        case "Prenom":
                            rs=adherentsCrud.searchAdherentByLastName(searched);
                            addEmpruntLivreView.UpdateView(rs);
                            break;
                        default:
                            break;
                    }
                }
            }
        });
        addEmpruntLivreView.getRechercheTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if(addEmpruntLivreView.getRechercheTextField().getText().equals("Recherche")){
                    addEmpruntLivreView.getRechercheTextField().setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(addEmpruntLivreView.getRechercheTextField().getText().isEmpty()){
                    addEmpruntLivreView.getRechercheTextField().setText("Recherche");
                }
            }
        
        });
        addEmpruntLivreView.getRechercheTextField().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(addEmpruntLivreView.getRechercheTextField().getText().equals("Recherche"))
                    addEmpruntLivreView.getRechercheTextField().setCaretPosition(0);
            }
        });
        
        addEmpruntLivreView.getAdherentTable().getSelectionModel().addListSelectionListener(e->selectionChanged());
        addEmpruntLivreView.getEmprunterButton().addActionListener(e->emprunter());
    }
    
    private void selectionChanged(){
        int row=addEmpruntLivreView.getAdherentTable().getSelectedRow();
        if(row!=-1 && Integer.parseInt(addEmpruntLivreView.getAdherentTable().getValueAt(row, 4).toString())!=2){
            addEmpruntLivreView.getEmprunterButton().setEnabled(true);
        }else{
            addEmpruntLivreView.getEmprunterButton().setEnabled(false);
        }
    }
    
    private void emprunter(){
        int row=addEmpruntLivreView.getAdherentTable().getSelectedRow();
        Emprunt emp=new Emprunt(livreId, (String)addEmpruntLivreView.getAdherentTable().getValueAt(row, 0));
        if(empruntsCrud.addEmprent(emp)){
            ((Window)SwingUtilities.getWindowAncestor(this.addEmpruntLivreView)).dispose();
        }
    }

}
