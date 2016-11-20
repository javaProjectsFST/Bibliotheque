
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
    
    public JLabel getExistLabel2(){
        return jLabel2;
    }
    
    public JLabel getIciLabel(){
        return iciLabel;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        existeLabel = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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

        jPanel10.setMinimumSize(new java.awt.Dimension(300, 64));
        jPanel10.setPreferredSize(new java.awt.Dimension(300, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Se Connecter");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(173, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(173, 173, 173))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(500, 70));

        jPanel12.setPreferredSize(new java.awt.Dimension(500, 40));

        existeLabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        existeLabel.setForeground(new java.awt.Color(255, 102, 102));
        existeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existeLabel.setText("Votre compte ou mot de passe est incorrect.");
        existeLabel.setMaximumSize(new java.awt.Dimension(500, 24));
        jPanel12.add(existeLabel);

        jPanel11.setPreferredSize(new java.awt.Dimension(100, 100));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setText("Si vous avez oublié votre mot de passe, cliquer");
        jPanel11.add(jLabel2);

        iciLabel.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        iciLabel.setForeground(new java.awt.Color(0, 153, 255));
        iciLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel11.add(iciLabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(625, 625, 625)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel existeLabel;
    private javax.swing.JLabel iciLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
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
