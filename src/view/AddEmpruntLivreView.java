
package view;

import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;

public class AddEmpruntLivreView extends javax.swing.JPanel {

    public AddEmpruntLivreView() {
        initComponents();
    }
    
    public JButton getEmprunterButton(){
        return emprunterButton;
    }
    
    public JTable getAdherentTable(){
        return adherentTable;
    }
    
    public JTextField getRechercheTextField(){
        return rechercheTextField;
    }
    
    public JComboBox getComboBox(){
        return comboBox;
    }
    
    public void UpdateView(ResultSet rs){
        adherentTable.setModel(DbUtils.resultSetToTableModel(rs));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        adherentTable = new javax.swing.JTable(){
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                if(column==0 && row==0)
                this.getTableHeader().setReorderingAllowed(false);

                String numbEmp=this.getModel().getValueAt(row, 4).toString();
                if(Integer.parseInt(numbEmp)==2){
                    c.setBackground(Color.decode("#feb5b5"));
                }else{
                    if(!isRowSelected(row)){
                        c.setBackground(row%2==0 ? Color.white : Color.decode("#f3f3f3"));
                    }else{
                        c.setBackground(Color.decode("#b8cfe5"));
                    }
                }
                return c;
            }
        };
        rechercheTextField = new javax.swing.JTextField();
        emprunterButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Choix d'un Adherent");

        adherentTable.setAutoCreateRowSorter(true);
        adherentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        adherentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        adherentTable.setFocusable(false);
        adherentTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(adherentTable);

        rechercheTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rechercheTextField.setText("Recherche");

        emprunterButton.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        emprunterButton.setText("Emprunter");
        emprunterButton.setEnabled(false);
        emprunterButton.setFocusable(false);

        comboBox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Login", "Email", "Nom", "Prenom" }));
        comboBox.setFocusable(false);
        comboBox.setPreferredSize(new java.awt.Dimension(65, 32));
        comboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(327, 327, 327)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emprunterButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emprunterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adherentTable;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JButton emprunterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField rechercheTextField;
    // End of variables declaration//GEN-END:variables

}
