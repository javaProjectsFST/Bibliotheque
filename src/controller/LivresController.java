
package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.LivresView;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmpruntsCRUD;
import model.CRUD.LivresCRUD;
import model.CRUD.ReservationsCRUD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JTable;
import model.entities.Livre;
import view.AdherentsView;

public class LivresController {
    private final LivresView livreView;
    private final Connection connexion;
    private final int sortColumn;
    private final LivresCRUD livresCrud;
    private final AdherentsCRUD adherentsCrud;
    private final EmpruntsCRUD empruntsCrud;
    private final ReservationsCRUD reservationsCRUD;

    public LivresController(LivresView livreView, AdherentsView adherentView, Connection connexion) {
        this.livreView = livreView;
        this.connexion = connexion;
        this.sortColumn = 1;
        this.livresCrud = new LivresCRUD(connexion, this.livreView);
        this.adherentsCrud = new AdherentsCRUD(connexion, adherentView);
        this.empruntsCrud = new EmpruntsCRUD(connexion, livresCrud);
        this.reservationsCRUD=new ReservationsCRUD(connexion, livresCrud);
        
        initView();
        initController();
    }
    
    private void initView(){
        ResultSet rs=livresCrud.getAllLivres(true);
        if(rs!=null){
            livreView.UpdateView(rs);
        }
    }
    
    private void initController(){
        livreView.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                looseTableFocus();
            }
        });
        livreView.getLivreTableScrollPane().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev){
                super.mousePressed(ev);
                looseTableFocus();
            }
        });
        livreView.getLivresTable().getModel().addTableModelListener(e->tableChanged());
    }
    
    private void tableChanged(){
        try {
            JTable table=livreView.getLivresTable();
            int row=table.getSelectedRow();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsed = format.parse(table.getValueAt(row, 4).toString());
            Date date = new Date(parsed.getTime());
            
            Livre livre=new Livre();
            livre.setId(Integer.parseInt(table.getValueAt(row, 0).toString()));
            livre.setTitre(table.getValueAt(row, 1).toString());
            livre.setAuteur(table.getValueAt(row, 2).toString());
            livre.setEditeur(table.getValueAt(row, 3).toString());
            livre.setDateEdition(date);
            
            livresCrud.updateLivre(livre.getId(), livre);
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
    }
    
    public LivresView getLivreView(){
        return livreView;
    }
    
    public void addBook(){
        looseTableFocus();
        new AddLivreController(connexion, livreView);
    }
    
    public void emprunterBook(){
    }
    
    public void deleteBook(){
        JTable table=livreView.getLivresTable();
        if(table.getSelectedRowCount()==1){
            int row=table.getSelectedRow();
            livresCrud.deleteLivreBy((int)table.getValueAt(row, 0));
        }else{
            int[] rows=table.getSelectedRows();
            for(int i=table.getSelectedRowCount()-1; i>=0; i--){
                livresCrud.deleteLivreBy((int)table.getValueAt(rows[i], 0));
            }
        }
    }
    
    public void reserveBook(){
        
    }
    
    public void looseTableFocus(){
        livreView.looseTableFocus();
    }
    
    private void sortBy(){
        
    }
    
    public void searchByFor(int col, String searched){
        ResultSet rs=null;
        if(searched.isEmpty()){
            rs=livresCrud.getAllLivres(true);
            livreView.UpdateView(rs);
        }else{
            switch(col){
                case 0:
                    rs=livresCrud.searchLivreByTitre(searched);
                    livreView.UpdateView(rs);
                    break;
                case 1:
                    rs=livresCrud.searchLivreByAuteur(searched);
                    livreView.UpdateView(rs);
                    break;
                case 2:
                    rs=livresCrud.searchLivreByEditeur(searched);
                    livreView.UpdateView(rs);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void searchByForInEmprunt(int col, String searched){
        ResultSet rs=null;
        if(searched.isEmpty()){
            rs=livresCrud.getAllLivresInEmprunt(true);
            livreView.UpdateView(rs);
        }else{
            switch(col){
                case 0:
                    rs=livresCrud.searchLivreByTitreInEmprunt(searched);
                    livreView.UpdateView(rs);
                    break;
                case 1:
                    rs=livresCrud.searchLivreByAuteurInEmprunt(searched);
                    livreView.UpdateView(rs);
                    break;
                case 2:
                    rs=livresCrud.searchLivreByEditeurInEmprunt(searched);
                    livreView.UpdateView(rs);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void searchByForInDateLim(int col, String searched){
        ResultSet rs=null;
        if(searched.isEmpty()){
            rs=livresCrud.getAllLivresInDateLim(true);
            livreView.UpdateView(rs);
        }else{
            switch(col){
                case 0:
                    rs=livresCrud.searchLivreByTitreInDateLim(searched);
                    livreView.UpdateView(rs);
                    break;
                case 1:
                    rs=livresCrud.searchLivreByAuteurInDateLim(searched);
                    livreView.UpdateView(rs);
                    break;
                case 2:
                    rs=livresCrud.searchLivreByEditeurInDateLim(searched);
                    livreView.UpdateView(rs);
                    break;
                default:
                    break;
            }
        }
    }
    
    public void searchByForInReservation(int col, String searched){
        ResultSet rs=null;
        if(searched.isEmpty()){
            rs=livresCrud.getAllLivresInReservation(true);
            livreView.UpdateView(rs);
        }else{
            switch(col){
                case 0:
                    rs=livresCrud.searchLivreByTitreInReservation(searched);
                    livreView.UpdateView(rs);
                    break;
                case 1:
                    rs=livresCrud.searchLivreByAuteurInReservation(searched);
                    livreView.UpdateView(rs);
                    break;
                case 2:
                    rs=livresCrud.searchLivreByEditeurInReservation(searched);
                    livreView.UpdateView(rs);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void addLivre(){
        
    }
    
    private void deleteLivre(){
        
    }
    
    private void updateLivre(){
        
    }
    
    private void resLivre(){
        
    }
    
    private void empLivre(){
        
    }
    
    private void cancelResLivre(){
        
    }
    
    private void livreRendu(){
        
    }
    
    private void sendAvertMail(){
        
    }
    
    private void showAllLivres(){
        
    }
    
    private void showLivresDisp(){
        
    }
    
    private void showLivresEmp(){
        
    }
    
    private void showLivresDepDateEmp(){
        
    }
    
    private void showLivresRes(){
        
    }
    
    private void showLivresDepDateRes(){
        
    }
}
