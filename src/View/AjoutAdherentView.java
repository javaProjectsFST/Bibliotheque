
package View;

import javax.swing.JButton;
import javax.swing.JTextField;

public class AjoutAdherentView extends javax.swing.JPanel {

    private JTextField mdpTextField;
    private JTextField loginTextField;
    private JTextField prenomTextField;
    private JTextField nomTextField;
    private JTextField emailTextField;
    
    private JButton ajoutButton;
    
    public AjoutAdherentView() {
        initComponents();
    }
    
    public JTextField getMdpTextField(){
        return mdpTextField;
    }
    
    public JTextField getLoginTextField(){
        return loginTextField;
    }
    
    public JTextField getNomTextField(){
        return nomTextField;
    }
    
    public JTextField getPrenomTextField(){
        return prenomTextField;
    }
    
    public JTextField getEmailTextField(){
        return emailTextField;
    }
    
    public JButton getAjoutButton(){
        return ajoutButton;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
