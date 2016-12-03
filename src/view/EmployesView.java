
package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import net.proteanit.sql.DbUtils;



public class EmployesView extends javax.swing.JPanel{
    
    public EmployesView() {
        initComponents();
        employesTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 15));

        Dimension dimension=new Dimension(employesTable.getTableHeader().getSize().width, 40);
        employesTable.getTableHeader().setPreferredSize(dimension);
        employesTable.getTableHeader().setMaximumSize(dimension);
        employesTable.getTableHeader().setMinimumSize(dimension);
    }
    
    public void UpdateView(ResultSet rs) {
        employesTable.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
    public JTable getEmployessTable(){
        return employesTable;
    }
    
    public void looseTableFocus(){
        this.employesTable.getSelectionModel().clearSelection();
    }
    
    public JScrollPane getLivreTableScrollPane(){
        return livreTableScrollPane;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        livreTableScrollPane = new javax.swing.JScrollPane();
        employesTable = new javax.swing.JTable(){
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                if(column==0 && row==0)
                this.getTableHeader().setReorderingAllowed(false);

                if(!isRowSelected(row)){
                    c.setBackground(row%2==0 ? Color.white : Color.decode("#f3f3f3"));
                }
                return c;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        depDateLimPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1600, 600));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1600, 600));

        employesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "LivreId", "Titre", "Auteur", "Editeur", "Date Edition", "DateEmprent", "DateLimiteEmprent", "DateReservation", "nullDateLimiteReservation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employesTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        employesTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employesTable.setFocusable(false);
        employesTable.setOpaque(false);
        employesTable.setRowHeight(30);
        livreTableScrollPane.setViewportView(employesTable);
        if (employesTable.getColumnModel().getColumnCount() > 0) {
            employesTable.getColumnModel().getColumn(0).setMinWidth(0);
            employesTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            employesTable.getColumnModel().getColumn(0).setMaxWidth(0);
            employesTable.getColumnModel().getColumn(1).setResizable(false);
            employesTable.getColumnModel().getColumn(2).setResizable(false);
            employesTable.getColumnModel().getColumn(3).setResizable(false);
            employesTable.getColumnModel().getColumn(4).setResizable(false);
            employesTable.getColumnModel().getColumn(5).setMinWidth(0);
            employesTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            employesTable.getColumnModel().getColumn(5).setMaxWidth(0);
            employesTable.getColumnModel().getColumn(6).setMinWidth(0);
            employesTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            employesTable.getColumnModel().getColumn(6).setMaxWidth(0);
            employesTable.getColumnModel().getColumn(7).setMinWidth(0);
            employesTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            employesTable.getColumnModel().getColumn(7).setMaxWidth(0);
            employesTable.getColumnModel().getColumn(8).setMinWidth(0);
            employesTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            employesTable.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        javax.swing.GroupLayout depDateLimPanelLayout = new javax.swing.GroupLayout(depDateLimPanel);
        depDateLimPanel.setLayout(depDateLimPanelLayout);
        depDateLimPanelLayout.setHorizontalGroup(
            depDateLimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 59, Short.MAX_VALUE)
        );
        depDateLimPanelLayout.setVerticalGroup(
            depDateLimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(908, Short.MAX_VALUE)
                .addComponent(depDateLimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(depDateLimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(livreTableScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(621, 621, 621)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(livreTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel depDateLimPanel;
    private javax.swing.JTable employesTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane livreTableScrollPane;
    // End of variables declaration//GEN-END:variables

}
