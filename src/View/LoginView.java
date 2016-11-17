
package View;

import javax.swing.JButton;
import javax.swing.JTextField;

public class LoginView extends javax.swing.JPanel {

    public LoginView() {
        initComponents();
    }
    
    public JTextField getMdpTextField(){
        return mdpTextField;
    }
    
    public JTextField getLoginTextField(){
        return loginTextField;
    }
    
    public JButton getConnectButton(){
        return connectButton;
    }
    
    public JButton getResetButton(){
        return resetButton;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        loginTextField = new javax.swing.JTextField();
        mdpTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1800, 680));
        setMinimumSize(new java.awt.Dimension(1800, 680));
        setPreferredSize(new java.awt.Dimension(1800, 680));
        setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.GridLayout(2, 1, 50, 50));
        add(jPanel1, new java.awt.GridBagConstraints());

        jPanel3.setMaximumSize(new java.awt.Dimension(400, 80));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 0, 30));

        loginTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        loginTextField.setMinimumSize(new java.awt.Dimension(150, 30));
        jPanel3.add(loginTextField);

        mdpTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel3.add(mdpTextField);

        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel6.setLayout(new java.awt.GridLayout(1, 2, 30, 0));

        connectButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        connectButton.setText("Connecter");
        connectButton.setFocusPainted(false);
        connectButton.setMaximumSize(new java.awt.Dimension(150, 40));
        connectButton.setMinimumSize(new java.awt.Dimension(150, 40));
        connectButton.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel6.add(connectButton);

        resetButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        resetButton.setText("Reset");
        resetButton.setFocusPainted(false);
        resetButton.setPreferredSize(new java.awt.Dimension(150, 40));
        jPanel6.add(resetButton);

        jPanel4.add(jPanel6, new java.awt.GridBagConstraints());

        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setText("Se Connecter");
        jPanel5.add(jLabel2, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JTextField mdpTextField;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables

}
