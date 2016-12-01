
package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import view.LivresView;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmpruntsCRUD;
import model.CRUD.LivresCRUD;
import model.CRUD.ReservationsCRUD;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
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
        this.empruntsCrud = new EmpruntsCRUD(connexion, livresCrud, adherentsCrud);
        this.reservationsCRUD=new ReservationsCRUD(connexion);
        
        initView();
        initController();
    }
    
    private void initView(){
        ResultSet rs=livresCrud.getAllLivres(true);
        if(rs!=null){
            livreView.getLivresTable().setModel(DbUtils.resultSetToTableModel(rs));
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
    
    private void searchByFor(){
        
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
