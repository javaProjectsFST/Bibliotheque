
package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DashboardView extends JPanel {

    private final ImageIcon cancelEmpruntIcon;
    private final ImageIcon empruntIcon;
    private final ImageIcon reserveIcon;
    private final ImageIcon cancelReserveIcon;
    
    public DashboardView() {
        initComponents();
        cancelEmpruntIcon=new ImageIcon(getClass().getResource("/resources/cancel_emprunt-book.png"));
        empruntIcon=new ImageIcon(getClass().getResource("/resources/emprunt-book.png"));
        reserveIcon=new ImageIcon(getClass().getResource("/resources/reserve-book.png"));
        cancelReserveIcon=new ImageIcon(getClass().getResource("/resources/cancel_reserve-book.png"));
    }
    
    public LivresView getLivresView(){
        return livresView;
    }
    
    public AdherentsView getAdherentsView(){
        return null;
    }
    
    public EmployesView getEmployesView(){
        return null;
    }
    
    public JButton getAddBookButton(){
        return addBookButton;
    }
    
    public JButton getDeleteBookButton(){
        return deleteBookButton;
    }
    
    public JTabbedPane getTabbedPane(){
        return tabbedPane;
    }
    
    public JButton getMakeReservationButton(){
        return makeReservationButton;
    }
    
    public JButton getEmpruntButton(){
        return empruntButton;
    }
    
    public void setEmpruntIcon(){
        empruntButton.setToolTipText("Faire un emprunt");
        empruntButton.setIcon(empruntIcon);
    }
    
    public void setCancelEmpruntIcon(){
        empruntButton.setToolTipText("Annuler un emprunt");
        empruntButton.setIcon(cancelEmpruntIcon);
    }
    
    public void setReserverIcon(){
        makeReservationButton.setToolTipText("Faire une reservation");
        makeReservationButton.setIcon(reserveIcon);
    }
    
    public void setCanceReserveIcon(){
        makeReservationButton.setToolTipText("Annuler une reservation");
        makeReservationButton.setIcon(cancelReserveIcon);
    }
    
    public int showEmpruntMessage(String login){
        String[] options={"Oui", "Annuler"};
        return JOptionPane.showOptionDialog(this, "Ce livre est reservé par l'adherent de login '"+login+"', voulez vous le lui emprunter?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        livresView = new view.LivresView();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        addBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        makeReservationButton = new javax.swing.JButton();
        empruntButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1800, 680));
        setMinimumSize(new java.awt.Dimension(1800, 680));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1800, 680));

        tabbedPane.setFocusable(false);
        tabbedPane.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tabbedPane.addTab("Livres", livresView);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.setPreferredSize(new java.awt.Dimension(316, 50));

        addBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-book.png"))); // NOI18N
        addBookButton.setToolTipText("Ajouter un Livre");
        addBookButton.setFocusable(false);

        deleteBookButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/delete-book.png"))); // NOI18N
        deleteBookButton.setToolTipText("Supprimer un livre");
        deleteBookButton.setEnabled(false);
        deleteBookButton.setFocusable(false);

        makeReservationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/reserve-book.png"))); // NOI18N
        makeReservationButton.setToolTipText("Faire une reservation");
        makeReservationButton.setEnabled(false);
        makeReservationButton.setFocusable(false);
        makeReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeReservationButtonActionPerformed(evt);
            }
        });

        empruntButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/emprunt-book.png"))); // NOI18N
        empruntButton.setToolTipText("Faire un emprunt");
        empruntButton.setEnabled(false);
        empruntButton.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(addBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empruntButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(makeReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteBookButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addBookButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(makeReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(empruntButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1603, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReservationButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeReservationButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JButton empruntButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private view.LivresView livresView;
    private javax.swing.JButton makeReservationButton;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables

}
