
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



public class LivresView extends javax.swing.JPanel{
    
    public LivresView() {
        initComponents();
        livreTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 15));

        Dimension dimension=new Dimension(livreTable.getTableHeader().getSize().width, 40);
        livreTable.getTableHeader().setPreferredSize(dimension);
        livreTable.getTableHeader().setMaximumSize(dimension);
        livreTable.getTableHeader().setMinimumSize(dimension);
    }
    
    public void UpdateView(ResultSet rs) {
        try{
            if(rs.next()){
                rs.beforeFirst();
                livreTable.setModel(DbUtils.resultSetToTableModel(rs));
            }else{
                String[] colHeadings={"LivreId", "Titre", "Auteur", "Editeur", "DateEdition", "DateEmprunt", "DateLimiteEmprunt", "DateReservation", "DateLimiteReservation"};
                DefaultTableModel model=new DefaultTableModel();
                model.setColumnIdentifiers(colHeadings);
                livreTable.setModel(model);
                
                
                livreTable.getColumn("LivreId").setMaxWidth(0);
                livreTable.getColumn("LivreId").setMinWidth(0);
                livreTable.getColumn("LivreId").setPreferredWidth(0);

                livreTable.getColumn("DateEmprunt").setMaxWidth(0);
                livreTable.getColumn("DateEmprunt").setMinWidth(0);
                livreTable.getColumn("DateEmprunt").setPreferredWidth(0);

                livreTable.getColumn("DateLimiteEmprunt").setMaxWidth(0);
                livreTable.getColumn("DateLimiteEmprunt").setMinWidth(0);
                livreTable.getColumn("DateLimiteEmprunt").setPreferredWidth(0);

                livreTable.getColumn("DateReservation").setMaxWidth(0);
                livreTable.getColumn("DateReservation").setMinWidth(0);
                livreTable.getColumn("DateReservation").setPreferredWidth(0);

                livreTable.getColumn("DateLimiteReservation").setMaxWidth(0);
                livreTable.getColumn("DateLimiteReservation").setMinWidth(0);
                livreTable.getColumn("DateLimiteReservation").setPreferredWidth(0);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public JTable getLivresTable(){
        return livreTable;
    }
    
    public void looseTableFocus(){
        this.livreTable.getSelectionModel().clearSelection();
    }
    
    public JScrollPane getLivreTableScrollPane(){
        return livreTableScrollPane;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        livreTableScrollPane = new javax.swing.JScrollPane();
        livreTable = new javax.swing.JTable(){
            public Component prepareRenderer(
                TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                if(column==0 && row==0)
                this.getTableHeader().setReorderingAllowed(false);

                if(column==0){
                    this.getColumn("LivreId").setPreferredWidth(0);
                    this.getColumn("LivreId").setMaxWidth(0);
                    this.getColumn("LivreId").setMinWidth(0);

                    this.getColumn("DateEmprunt").setPreferredWidth(0);
                    this.getColumn("DateEmprunt").setMaxWidth(0);
                    this.getColumn("DateEmprunt").setMinWidth(0);

                    this.getColumn("DateLimiteEmprunt").setPreferredWidth(0);
                    this.getColumn("DateLimiteEmprunt").setMaxWidth(0);
                    this.getColumn("DateLimiteEmprunt").setMinWidth(0);

                    this.getColumn("DateReservation").setPreferredWidth(0);
                    this.getColumn("DateReservation").setMaxWidth(0);
                    this.getColumn("DateReservation").setMinWidth(0);

                    this.getColumn("DateLimiteReservation").setPreferredWidth(0);
                    this.getColumn("DateLimiteReservation").setMaxWidth(0);
                    this.getColumn("DateLimiteReservation").setMinWidth(0);
                }

                Object dateEmp=this.getModel().getValueAt(row, 5);
                Object dateRes=this.getModel().getValueAt(row, 7);
                if(!isRowSelected(row)){
                    if(dateEmp!=null){
                        try {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            java.util.Date parsed = format.parse(livreTable.getModel().getValueAt(row, 6).toString());
                            Date dateLim = new Date(parsed.getTime());

                            Calendar calendar = Calendar.getInstance();
                            Date date=new Date(calendar.getTime().getTime());

                            if(date.after(dateLim)){
                                c.setBackground(Color.decode("#feb5b5"));
                            }else{
                                c.setBackground(Color.decode("#CCFFCC"));
                            }
                        } catch (java.text.ParseException ex) {
                            ex.printStackTrace();
                        }
                    }else if(dateRes!=null){
                        c.setBackground(Color.decode("#CCFFFF"));
                    }else{
                        c.setBackground(row%2==0 ? Color.white : Color.decode("#f3f3f3"));
                    }
                }else{
                    c.setBackground(Color.decode("#b8cfe5"));
                }
                return c;
            }
        };
        jPanel1 = new javax.swing.JPanel();
        bluePanel = new javax.swing.JPanel();
        greenPanel = new javax.swing.JPanel();
        empLabel = new javax.swing.JLabel();
        resLabel = new javax.swing.JLabel();
        depDateLimPanel = new javax.swing.JPanel();
        empLabel1 = new javax.swing.JLabel();
        greenPanel1 = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(1600, 600));
        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(1600, 600));

        livreTable.setModel(new javax.swing.table.DefaultTableModel(
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
        livreTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        livreTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        livreTable.setFocusable(false);
        livreTable.setOpaque(false);
        livreTable.setRowHeight(30);
        livreTableScrollPane.setViewportView(livreTable);
        if (livreTable.getColumnModel().getColumnCount() > 0) {
            livreTable.getColumnModel().getColumn(0).setMinWidth(0);
            livreTable.getColumnModel().getColumn(0).setPreferredWidth(0);
            livreTable.getColumnModel().getColumn(0).setMaxWidth(0);
            livreTable.getColumnModel().getColumn(1).setResizable(false);
            livreTable.getColumnModel().getColumn(2).setResizable(false);
            livreTable.getColumnModel().getColumn(3).setResizable(false);
            livreTable.getColumnModel().getColumn(4).setResizable(false);
            livreTable.getColumnModel().getColumn(5).setMinWidth(0);
            livreTable.getColumnModel().getColumn(5).setPreferredWidth(0);
            livreTable.getColumnModel().getColumn(5).setMaxWidth(0);
            livreTable.getColumnModel().getColumn(6).setMinWidth(0);
            livreTable.getColumnModel().getColumn(6).setPreferredWidth(0);
            livreTable.getColumnModel().getColumn(6).setMaxWidth(0);
            livreTable.getColumnModel().getColumn(7).setMinWidth(0);
            livreTable.getColumnModel().getColumn(7).setPreferredWidth(0);
            livreTable.getColumnModel().getColumn(7).setMaxWidth(0);
            livreTable.getColumnModel().getColumn(8).setMinWidth(0);
            livreTable.getColumnModel().getColumn(8).setPreferredWidth(0);
            livreTable.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        bluePanel.setBackground(new java.awt.Color(204, 255, 255));
        bluePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        bluePanel.setMaximumSize(new java.awt.Dimension(60, 20));
        bluePanel.setMinimumSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout bluePanelLayout = new javax.swing.GroupLayout(bluePanel);
        bluePanel.setLayout(bluePanelLayout);
        bluePanelLayout.setHorizontalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        bluePanelLayout.setVerticalGroup(
            bluePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        greenPanel.setBackground(new java.awt.Color(204, 255, 204));
        greenPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        greenPanel.setMaximumSize(new java.awt.Dimension(60, 20));
        greenPanel.setMinimumSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout greenPanelLayout = new javax.swing.GroupLayout(greenPanel);
        greenPanel.setLayout(greenPanelLayout);
        greenPanelLayout.setHorizontalGroup(
            greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        greenPanelLayout.setVerticalGroup(
            greenPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        empLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        empLabel.setText("Emprunté");

        resLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        resLabel.setText("Reservé");

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

        empLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        empLabel1.setText("Date Limite Depassé");

        greenPanel1.setBackground(new java.awt.Color(254, 181, 181));
        greenPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        greenPanel1.setMaximumSize(new java.awt.Dimension(60, 20));
        greenPanel1.setMinimumSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout greenPanel1Layout = new javax.swing.GroupLayout(greenPanel1);
        greenPanel1.setLayout(greenPanel1Layout);
        greenPanel1Layout.setHorizontalGroup(
            greenPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        greenPanel1Layout.setVerticalGroup(
            greenPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(621, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bluePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(resLabel)
                            .addComponent(empLabel)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(greenPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(empLabel1)))
                .addGap(18, 18, 18)
                .addComponent(depDateLimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(empLabel)
                    .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(depDateLimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(empLabel1)
                            .addComponent(greenPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resLabel))))
                .addContainerGap())
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
                .addComponent(livreTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bluePanel;
    private javax.swing.JPanel depDateLimPanel;
    private javax.swing.JLabel empLabel;
    private javax.swing.JLabel empLabel1;
    private javax.swing.JPanel greenPanel;
    private javax.swing.JPanel greenPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable livreTable;
    private javax.swing.JScrollPane livreTableScrollPane;
    private javax.swing.JLabel resLabel;
    // End of variables declaration//GEN-END:variables

}
