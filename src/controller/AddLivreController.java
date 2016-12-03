
package controller;

import java.awt.Window;
import java.sql.Connection;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.CRUD.LivresCRUD;
import model.entities.Livre;
import view.AddLivreView;
import view.LivresView;

public class AddLivreController {

    private final AddLivreView addLivreView;
    private final LivresCRUD livreCrud;
    
    public AddLivreController(Connection connexion, LivresView livreView){
        this.addLivreView=new AddLivreView();
        this.livreCrud=new LivresCRUD(connexion, livreView);
        
        initView();
        initController();
        JOptionPane.showOptionDialog(null, this.addLivreView, "Ajouter Livre", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, "");
    }
    
    public void initView(){
        addLivreView.getDateEditionDatePicker().setFormats(new String[] {"yyyy/MM/dd"});
        addLivreView.getDateEditionDatePicker().getEditor().setEditable(false);
    }
    
    public void initController(){
        addLivreView.getAjoutButton().addActionListener(e -> ajouterLivre());
        addLivreView.getResetButton().addActionListener(e -> reset());
    }
    
    private void reset(){
        addLivreView.getTitreTextField().setText("");
        addLivreView.getAuteurTextField().setText("");
        addLivreView.getEditeurTextField().setText("");
        addLivreView.getDateEditionDatePicker().setDate(null);
    }
    
    private boolean isValidForm(String titre, String auteur, String editeur, Date date){
        if(titre.isEmpty()){
            JOptionPane.showMessageDialog(addLivreView, "Le champs titre est obligatoire!");
            return false;
        }else if(auteur.isEmpty()){
            JOptionPane.showMessageDialog(addLivreView, "Le champs auteur est obligatoire!");
            return false;
        }else if(editeur.isEmpty()){
            JOptionPane.showMessageDialog(addLivreView, "Le champs editeur est obligatoire!");
            return false;
        }else if(date.toString().isEmpty()){
            JOptionPane.showMessageDialog(addLivreView, "Le champs date edition est obligatoire!");
            return false;
        }
        return true;
    }
    
    public void ajouterLivre(){
        String titre=addLivreView.getTitreTextField().getText();
        String auteur=addLivreView.getAuteurTextField().getText();
        String editeur=addLivreView.getEditeurTextField().getText();
        Date date=null;
        if(addLivreView.getDateEditionDatePicker().getDate()!=null){
            date=new Date(addLivreView.getDateEditionDatePicker().getDate().getTime());
            if(isValidForm(titre, auteur, editeur, date)){
                Livre livre=new Livre(titre, auteur, editeur, date);
                livreCrud.addLivre(livre);
                ((Window)SwingUtilities.getWindowAncestor(this.addLivreView)).dispose();
            }
        }else{
            JOptionPane.showMessageDialog(addLivreView, "Le champs date edition est obligatoire!");
        }
    }
    
}
