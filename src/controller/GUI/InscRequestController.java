
package controller.GUI;

import View.InscRequestView;
import javax.swing.JOptionPane;

public class InscRequestController {
    private final InscRequestView inscRequestView;
    
    public InscRequestController(){
        this.inscRequestView=new InscRequestView();
        JOptionPane.showOptionDialog(null, this.inscRequestView, "Demande d'inscription", 0, JOptionPane.PLAIN_MESSAGE, null, new String[]{}, new String(""));
    }
}
