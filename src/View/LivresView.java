
package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class LivresView extends javax.swing.JPanel {
    
    public LivresView() {
        initComponents();
        livreTable.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 15));
        
        Dimension dimension=new Dimension(livreTable.getTableHeader().getSize().width, 40);
        livreTable.getTableHeader().setPreferredSize(dimension);
        livreTable.getTableHeader().setMaximumSize(dimension);
        livreTable.getTableHeader().setMinimumSize(dimension);
    }
    
    public JTable getLivresTable(){
        return livreTable;
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

                if(!isRowSelected(row)){
                    c.setBackground(row%2==0 ? Color.white : Color.decode("#f3f3f3"));
                }else{
                    c.setBackground(Color.decode("#b8cfe5"));
                }

                return c;
            }
        };
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelResButton = new javax.swing.JButton();
        resButton = new javax.swing.JButton();
        empButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        redPanel = new javax.swing.JPanel();
        bluePanel = new javax.swing.JPanel();
        greenPanel = new javax.swing.JPanel();
        empLabel = new javax.swing.JLabel();
        resLabel = new javax.swing.JLabel();
        depDateLimPanel = new javax.swing.JPanel();
        depDateLimLabel1 = new javax.swing.JLabel();
        depDateLimLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1600, 600));
        setMinimumSize(new java.awt.Dimension(1600, 600));
        setPreferredSize(new java.awt.Dimension(1600, 600));

        livreTable.setBackground(new java.awt.Color(255, 255, 255));
        livreTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Titre", "Auteur", "Editeur", "Date Edition", "Date d'Emprent", "Date Limite d'Emprent", "Date de Reservation", "Date Limite de Reservation"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        livreTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        livreTable.setFocusable(false);
        livreTable.setOpaque(false);
        livreTable.setRowHeight(30);
        livreTableScrollPane.setViewportView(livreTable);
        if (livreTable.getColumnModel().getColumnCount() > 0) {
            livreTable.getColumnModel().getColumn(0).setResizable(false);
            livreTable.getColumnModel().getColumn(1).setResizable(false);
            livreTable.getColumnModel().getColumn(2).setResizable(false);
            livreTable.getColumnModel().getColumn(3).setResizable(false);
            livreTable.getColumnModel().getColumn(3).setPreferredWidth(50);
            livreTable.getColumnModel().getColumn(4).setResizable(false);
            livreTable.getColumnModel().getColumn(4).setPreferredWidth(50);
            livreTable.getColumnModel().getColumn(5).setResizable(false);
            livreTable.getColumnModel().getColumn(5).setPreferredWidth(70);
            livreTable.getColumnModel().getColumn(6).setResizable(false);
            livreTable.getColumnModel().getColumn(6).setPreferredWidth(70);
            livreTable.getColumnModel().getColumn(7).setResizable(false);
        }

        addButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        addButton.setText("Ajouter");
        addButton.setFocusable(false);
        addButton.setMaximumSize(new java.awt.Dimension(150, 50));
        addButton.setMinimumSize(new java.awt.Dimension(150, 50));
        addButton.setPreferredSize(new java.awt.Dimension(150, 50));

        deleteButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        deleteButton.setText("Supprimer");
        deleteButton.setFocusable(false);
        deleteButton.setMaximumSize(new java.awt.Dimension(150, 50));
        deleteButton.setMinimumSize(new java.awt.Dimension(150, 50));
        deleteButton.setPreferredSize(new java.awt.Dimension(150, 50));

        updateButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        updateButton.setText("Mettre à Jours");
        updateButton.setFocusable(false);
        updateButton.setMaximumSize(new java.awt.Dimension(150, 50));
        updateButton.setMinimumSize(new java.awt.Dimension(150, 50));
        updateButton.setPreferredSize(new java.awt.Dimension(150, 50));

        cancelResButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cancelResButton.setText("Annuler la reservation");
        cancelResButton.setFocusable(false);
        cancelResButton.setMaximumSize(new java.awt.Dimension(150, 50));
        cancelResButton.setMinimumSize(new java.awt.Dimension(150, 50));
        cancelResButton.setPreferredSize(new java.awt.Dimension(150, 50));

        resButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        resButton.setText("Reserver");
        resButton.setFocusable(false);
        resButton.setMaximumSize(new java.awt.Dimension(150, 50));
        resButton.setMinimumSize(new java.awt.Dimension(150, 50));
        resButton.setPreferredSize(new java.awt.Dimension(150, 50));

        empButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        empButton.setText("Emprunter");
        empButton.setFocusable(false);
        empButton.setMaximumSize(new java.awt.Dimension(150, 50));
        empButton.setMinimumSize(new java.awt.Dimension(150, 50));
        empButton.setPreferredSize(new java.awt.Dimension(150, 50));

        returnButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        returnButton.setText("Livre Rendu");
        returnButton.setFocusable(false);
        returnButton.setMaximumSize(new java.awt.Dimension(150, 50));
        returnButton.setMinimumSize(new java.awt.Dimension(150, 50));
        returnButton.setPreferredSize(new java.awt.Dimension(150, 50));

        redPanel.setBackground(new java.awt.Color(255, 204, 204));
        redPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        redPanel.setMaximumSize(new java.awt.Dimension(60, 20));
        redPanel.setMinimumSize(new java.awt.Dimension(60, 20));
        redPanel.setPreferredSize(new java.awt.Dimension(60, 20));

        javax.swing.GroupLayout redPanelLayout = new javax.swing.GroupLayout(redPanel);
        redPanel.setLayout(redPanelLayout);
        redPanelLayout.setHorizontalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        redPanelLayout.setVerticalGroup(
            redPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

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

        depDateLimLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        depDateLimLabel1.setText("Depassement de Date");

        depDateLimLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        depDateLimLabel2.setText("Limite d'Emprunt");

        javax.swing.GroupLayout depDateLimPanelLayout = new javax.swing.GroupLayout(depDateLimPanel);
        depDateLimPanel.setLayout(depDateLimPanelLayout);
        depDateLimPanelLayout.setHorizontalGroup(
            depDateLimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depDateLimPanelLayout.createSequentialGroup()
                .addGroup(depDateLimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(depDateLimLabel1)
                    .addGroup(depDateLimPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(depDateLimLabel2)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        depDateLimPanelLayout.setVerticalGroup(
            depDateLimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depDateLimPanelLayout.createSequentialGroup()
                .addComponent(depDateLimLabel1)
                .addGap(0, 0, 0)
                .addComponent(depDateLimLabel2))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(686, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bluePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(redPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(resLabel)
                    .addComponent(empLabel)
                    .addComponent(depDateLimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(empLabel)
                            .addComponent(greenPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(bluePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(resLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(depDateLimPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(redPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(livreTableScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(empButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(cancelResButton, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(146, 146, 146))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addComponent(livreTableScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelResButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel bluePanel;
    private javax.swing.JButton cancelResButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel depDateLimLabel1;
    private javax.swing.JLabel depDateLimLabel2;
    private javax.swing.JPanel depDateLimPanel;
    private javax.swing.JButton empButton;
    private javax.swing.JLabel empLabel;
    private javax.swing.JPanel greenPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTable livreTable;
    private javax.swing.JScrollPane livreTableScrollPane;
    private javax.swing.JPanel redPanel;
    private javax.swing.JButton resButton;
    private javax.swing.JLabel resLabel;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

}
