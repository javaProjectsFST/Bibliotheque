
package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends javax.swing.JPanel {

    public LoginView() {
        initComponents();
    }
    
    public JPasswordField getMdpTextField(){
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
    
    public JLabel getExistLabel(){
        return existeLabel;
    }
    
    public JLabel getIciLabel(){
        return iciLabel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        existeLabel = new javax.swing.JLabel();
        iciLabel = new javax.swing.JLabel("<HTML><U>ici</U></HTML>");
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        loginTextField = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        mdpTextField = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        connectButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1800, 680));
        setMinimumSize(new java.awt.Dimension(1800, 680));
        setPreferredSize(new java.awt.Dimension(1800, 680));
        setLayout(new java.awt.GridBagLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel8.setLayout(new java.awt.GridLayout(2, 1));

        jPanel10.setMinimumSize(new java.awt.Dimension(300, 64));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Se Connecter");
        jPanel10.add(jLabel1);

        jPanel8.add(jPanel10);

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 40));

        existeLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        existeLabel.setForeground(new java.awt.Color(255, 102, 102));
        existeLabel.setText("Ce compte n'existe pas, faire une demande d'inscription");
        existeLabel.setMaximumSize(new java.awt.Dimension(500, 24));
        jPanel1.add(existeLabel);

        iciLabel.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        iciLabel.setForeground(new java.awt.Color(0, 153, 255));
        iciLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(iciLabel);

        jPanel8.add(jPanel1);

        jPanel2.add(jPanel8, new java.awt.GridBagConstraints());

        jPanel3.setMaximumSize(new java.awt.Dimension(600, 80));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 80));
        jPanel3.setPreferredSize(new java.awt.Dimension(550, 100));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jPanel7.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel7.setLayout(new java.awt.GridLayout(2, 1, 0, 20));

        loginTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        loginTextField.setMinimumSize(new java.awt.Dimension(150, 30));
        loginTextField.setPreferredSize(new java.awt.Dimension(250, 32));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(loginTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel5);

        mdpTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mdpTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mdpTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel9);

        jPanel3.add(jPanel7, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setPreferredSize(new java.awt.Dimension(478, 10));
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 70;
        gridBagConstraints.ipady = 59;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 0, 6, 0);
        jPanel2.add(jPanel4, gridBagConstraints);

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel existeLabel;
    private javax.swing.JLabel iciLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JPasswordField mdpTextField;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables

}
