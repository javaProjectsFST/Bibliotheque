
package controller;

import java.awt.Window;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.CRUD.LivresCRUD;
import view.LivreDetailView;

public class LivreDetailsController {
    private final LivreDetailView livreDetailView;
    private final LivresCRUD livresCrud;
    private final Connection connexion;
    private final int livreId;
    
    public LivreDetailsController(Connection connexion, LivresCRUD livresCrud, int livreId){
        this.connexion=connexion;
        this.livresCrud=livresCrud;
        this.livreId=livreId;
        this.livreDetailView=new LivreDetailView();
        
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.livreDetailView, "Détailles du Livre", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    private void initView(){
        ResultSet rs=livresCrud.getLivreDetails(livreId);
        if(rs!=null){
            livreDetailView.updateView(rs);
        }
    }
    
    private void initController(){
        livreDetailView.getOkButton().addActionListener(e->okClicked());
    }
    
    private void okClicked(){
        ((Window)SwingUtilities.getWindowAncestor(livreDetailView)).dispose();
    }
}
