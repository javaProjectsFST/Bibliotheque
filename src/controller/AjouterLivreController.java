
package controller;

import java.sql.Connection;
import java.sql.Date;
import javax.swing.JOptionPane;
import model.CRUD.LivresCRUD;
import model.entities.Livre;
import view.AddLivreView;

public class AjouterLivreController {

    private final AddLivreView addLivreView;
    private final LivresCRUD livreCrud;
    
    public AjouterLivreController(Connection connexion){
        this.addLivreView=new AddLivreView();
        this.livreCrud=new LivresCRUD(connexion);
        
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.addLivreView, "Ajouter Livre", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    public void initView(){
        addLivreView.getDateEditionDatePicker().setFormats(new String[] {"yyyy/MM/dd"});
    }
    
    public void initController(){
        addLivreView.getAjoutButton().addActionListener(e -> ajouterLivre());
    }
    
    private boolean isValidForm(String titre, String auteur, String editeur, Date date){
        if(titre.isEmpty() || auteur.isEmpty() || editeur.isEmpty() || date.toString().isEmpty())
            return false;
        return true;
    }
    
    public void ajouterLivre(){
        String titre=addLivreView.getTitreTextField().getText();
        String auteur=addLivreView.getAuteurTextField().getText();
        String editeur=addLivreView.getEditeurTextField().getText();
        Date date=new Date(addLivreView.getDateEditionDatePicker().getDate().getTime());
        if(isValidForm(titre, auteur, editeur, date)){
            Livre livre=new Livre(titre, auteur, editeur, date);
            livreCrud.addLivre(livre);
        }
    }
    
}
