
package controller;

import java.sql.Connection;
import javax.swing.JOptionPane;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmpruntsCRUD;
import model.CRUD.LivresCRUD;
import view.AddEmpruntLivreView;

public class AddEmpruntLivreController {
    
    private final Connection connexion;
    private final AdherentsCRUD adherentsCrud;
    private final LivresCRUD livresCrud;
    private final EmpruntsCRUD empruntsCrud;
    private final AddEmpruntLivreView addEmpruntLivreView;
    
    public AddEmpruntLivreController(Connection connexion, LivresCRUD livresCrud, AdherentsCRUD adherentsCrud){
        this.connexion=connexion;
        this.adherentsCrud=adherentsCrud;
        this.livresCrud=livresCrud;
        this.empruntsCrud=new EmpruntsCRUD(this.connexion, livresCrud, adherentsCrud);
        this.addEmpruntLivreView=new AddEmpruntLivreView();
        
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.addEmpruntLivreView, "Choix Adherent", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    private void initView(){
        
    }
    
    private void initController(){
        
    }

}
