
package view;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class DashboardView extends JPanel {

    private final ImageIcon cancelEmpruntIcon;
    private final ImageIcon empruntIcon;
    private final ImageIcon reserveIcon;
    private final ImageIcon cancelReserveIcon;
    
    private final Color selectedColor;
    private final Color unSelectedColor;
    private final Color clickedColor;
    private final Color hoveredColor;

    private Color toutPanelColor;
    private Color empruntePanelColor;
    private Color dateLimitePanelColor;
    private Color reservesPanelColor;
    
    private int selectedIndex;
    
    public DashboardView() {
        initComponents();
        cancelEmpruntIcon=new ImageIcon(getClass().getResource("/resources/cancel_emprunt-book.png"));
        empruntIcon=new ImageIcon(getClass().getResource("/resources/emprunt-book.png"));
        reserveIcon=new ImageIcon(getClass().getResource("/resources/reserve-book.png"));
        cancelReserveIcon=new ImageIcon(getClass().getResource("/resources/cancel_reserve-book.png"));
        
        selectedColor=Color.decode("#abb8c5");
        clickedColor=Color.decode("#8c98a4");
        unSelectedColor=Color.decode("#ececec");
        hoveredColor=Color.decode("#b8cfe5");
        
        toutPanelColor=selectedColor;
        empruntePanelColor=unSelectedColor;
        dateLimitePanelColor=unSelectedColor;
        reservesPanelColor=unSelectedColor;
        
        selectedIndex=1;
    }
    
    public int getSelectedIndex(){
        return selectedIndex;
    }
    
    public Color getSelectedColor() {
        return selectedColor;
    }

    public Color getUnSelectedColor() {
        return unSelectedColor;
    }

    public Color getClickedColor() {
        return clickedColor;
    }

    public Color getHoveredColor() {
        return hoveredColor;
    }
    
    public void updateMenu(){
        toutPanel.setBackground(toutPanelColor);
        empruntesPanel.setBackground(empruntePanelColor);
        dateLimitePanel.setBackground(dateLimitePanelColor);
        reservesPanel.setBackground(reservesPanelColor);
    }
    
    public void unClickAll(){
        selectedIndex=0;
        toutPanelColor=unSelectedColor;
        empruntePanelColor=unSelectedColor;
        dateLimitePanelColor=unSelectedColor;
        reservesPanelColor=unSelectedColor;
        updateMenu();
    }
    
    public void toutPanelSelected() {
        selectedIndex=1;
        toutPanelColor=selectedColor;
        updateMenu();
    }
    
    public void emprentePanelSelected() {
        selectedIndex=2;
        empruntePanelColor=selectedColor;
        updateMenu();
    }
    
    public void dateLimitePanelSelected() {
        selectedIndex=3;
        dateLimitePanelColor=selectedColor;
        updateMenu();
    }
    
    public void reservesPanelSelected() {
        selectedIndex=2;
        reservesPanelColor=selectedColor;
        updateMenu();
    }
    
    public Color getToutPanelColor() {
        return toutPanelColor;
    }

    public Color getEmpruntePanelColor() {
        return empruntePanelColor;
    }

    public Color getDateLimitePanelColor() {
        return dateLimitePanelColor;
    }

    public Color getReservesPanelColor() {
        return reservesPanelColor;
    }
    
    public LivresView getLivresView(){
        return livresView;
    }
    
    public AdherentsView getAdherentsView(){
        return adherentsView;
    }
    
    public EmployesView getEmployesView(){
        return employesView;
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
    
    public JPanel getToutPanel(){
        return toutPanel;
    }
    
    public JLabel getToutNumber(){
        return toutNumber;
    }
    
    public JPanel getEmpruntesPanel(){
        return empruntesPanel;
    }
    
    public JLabel getEmpruntesNumber(){
        return empruntesNumber;
    }
    
    public JPanel getDateLimitePanel(){
        return dateLimitePanel;
    }
    
    public JLabel getDateLimiteNumber(){
        return dateLimiteNumber;
    }
    
    public JPanel getReservesPanel(){
        return reservesPanel;
    }
    
    public JLabel getReservesNumber(){
        return reservesNumber;
    }
    
    public JTextField getRechercheTextField(){
        return rechercheTextField;
    }
    
    public void setComboForLivre(){
        comboBox.removeAllItems();
        comboBox.addItem("Titre");
        comboBox.addItem("Auteur");
        comboBox.addItem("Editeur");
    }
    
    public void setComboForEmploye(){
        comboBox.removeAllItems();
        comboBox.addItem("Login");
        comboBox.addItem("Prenom");
        comboBox.addItem("Nom");
    }
    
    public void setComboForAdherent(){
        comboBox.removeAllItems();
        comboBox.addItem("Login");
        comboBox.addItem("Prenom");
        comboBox.addItem("Nom");
    }
    
    public JComboBox getComboBox(){
        return comboBox;
    }
    
    public JButton getLogoutButton(){
        return logoutButton;
    }
    
    public JButton getEmailButton(){
        return emailButton;
    }
    
    public JButton getDetailsButton(){
        return detailsButton;
    }
    
    private void allInvisible(){
        detailsButton.setVisible(false);
        toutPanel.setVisible(false);
        empruntesPanel.setVisible(false);
        dateLimitePanel.setVisible(false);
        reservesPanel.setVisible(false);
        addBookButton.setVisible(false);
        deleteBookButton.setVisible(false);
        empruntButton.setVisible(false);
        makeReservationButton.setVisible(false);
        emailButton.setVisible(false);
        addAdherentButton.setVisible(false);
        removeAdherentButton.setVisible(false);
        addEmployeButton.setVisible(false);
        removeEmployeButton.setVisible(false);
    }
    
    public void gerantInterface(){
        allInvisible();
    }
    
    public void livreTabVisible(int connectedIndex){
        allInvisible();
        switch(connectedIndex){
            case 1:
                empruntButton.setVisible(false);
                makeReservationButton.setVisible(false);
                emailButton.setVisible(false);
                addBookButton.setVisible(true);
                deleteBookButton.setVisible(true);
                detailsButton.setVisible(true);
                break;
            case 2:
                empruntButton.setVisible(false);
                makeReservationButton.setVisible(false);
                emailButton.setVisible(false);
                addBookButton.setVisible(false);
                deleteBookButton.setVisible(false);
                detailsButton.setVisible(false);
                break;
            case 3:
                empruntButton.setVisible(true);
                makeReservationButton.setVisible(true);
                emailButton.setVisible(true);
                addBookButton.setVisible(false);
                deleteBookButton.setVisible(false);
                detailsButton.setVisible(true);
                break;
            default:
                break;
        }
        statisticPanel.setVisible(true);
        toutPanel.setVisible(true);
        empruntesPanel.setVisible(true);
        dateLimitePanel.setVisible(true);
        reservesPanel.setVisible(true);
    }
    
    public void adherentTabVisible(int connectedIndex){
        allInvisible();
        addAdherentButton.setVisible(true);
        removeAdherentButton.setVisible(true);
    }
    
    public void employeTabVisible(int connectedIndex){
        allInvisible();
        addEmployeButton.setVisible(true);
        removeEmployeButton.setVisible(true);
    }
    
    public JButton getAddAdherentButton(){
        return addAdherentButton;
    }
    
    public JButton getRemoveAdherentButton(){
        return removeAdherentButton;
    }
    
    public JButton getAddEmployeButton(){
        return addEmployeButton;
    }
    
    public JButton getRemoveEmployeButton(){
        return removeEmployeButton;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        livresView = new view.LivresView();
        adherentsView = new view.AdherentsView();
        employesView = new view.EmployesView();
        statisticPanel = new javax.swing.JPanel();
        empruntesPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        empruntesNumber = new javax.swing.JLabel();
        toutPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        toutNumber = new javax.swing.JLabel();
        dateLimitePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dateLimiteNumber = new javax.swing.JLabel();
        reservesPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        reservesNumber = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        makeReservationButton = new javax.swing.JButton();
        empruntButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        emailButton = new javax.swing.JButton();
        addAdherentButton = new javax.swing.JButton();
        removeAdherentButton = new javax.swing.JButton();
        addEmployeButton = new javax.swing.JButton();
        removeEmployeButton = new javax.swing.JButton();
        rechercheTextField = new javax.swing.JTextField();
        comboBox = new javax.swing.JComboBox<>();
        detailsButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1800, 680));
        setMinimumSize(new java.awt.Dimension(1800, 680));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1800, 680));

        tabbedPane.setFocusable(false);
        tabbedPane.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        tabbedPane.addTab("Livres", livresView);
        tabbedPane.addTab("Adherents", adherentsView);
        tabbedPane.addTab("Employes", employesView);

        statisticPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        statisticPanel.setPreferredSize(new java.awt.Dimension(197, 261));

        empruntesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        empruntesPanel.setPreferredSize(new java.awt.Dimension(142, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Empruntés");

        empruntesNumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        empruntesNumber.setText("(51)");

        javax.swing.GroupLayout empruntesPanelLayout = new javax.swing.GroupLayout(empruntesPanel);
        empruntesPanel.setLayout(empruntesPanelLayout);
        empruntesPanelLayout.setHorizontalGroup(
            empruntesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empruntesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(empruntesNumber)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        empruntesPanelLayout.setVerticalGroup(
            empruntesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(empruntesPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(empruntesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(empruntesNumber))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        toutPanel.setBackground(new java.awt.Color(171, 184, 197));
        toutPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Tout");

        toutNumber.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        toutNumber.setText("(115)");

        javax.swing.GroupLayout toutPanelLayout = new javax.swing.GroupLayout(toutPanel);
        toutPanel.setLayout(toutPanelLayout);
        toutPanelLayout.setHorizontalGroup(
            toutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toutPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(toutNumber)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        toutPanelLayout.setVerticalGroup(
            toutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toutPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(toutPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(toutNumber))
                .addGap(4, 4, 4))
        );

        dateLimitePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel5.setText("Date Limite Depassé");

        dateLimiteNumber.setText("(15)");

        javax.swing.GroupLayout dateLimitePanelLayout = new javax.swing.GroupLayout(dateLimitePanel);
        dateLimitePanel.setLayout(dateLimitePanelLayout);
        dateLimitePanelLayout.setHorizontalGroup(
            dateLimitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateLimitePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateLimiteNumber)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        dateLimitePanelLayout.setVerticalGroup(
            dateLimitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dateLimitePanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(dateLimitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dateLimiteNumber))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        reservesPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reservesPanel.setPreferredSize(new java.awt.Dimension(142, 30));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Reservés");

        reservesNumber.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        reservesNumber.setText("(24)");

        javax.swing.GroupLayout reservesPanelLayout = new javax.swing.GroupLayout(reservesPanel);
        reservesPanel.setLayout(reservesPanelLayout);
        reservesPanelLayout.setHorizontalGroup(
            reservesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservesPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reservesNumber)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        reservesPanelLayout.setVerticalGroup(
            reservesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservesPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(reservesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(reservesNumber))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout statisticPanelLayout = new javax.swing.GroupLayout(statisticPanel);
        statisticPanel.setLayout(statisticPanelLayout);
        statisticPanelLayout.setHorizontalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toutPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(empruntesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
            .addComponent(dateLimitePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reservesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
        );
        statisticPanelLayout.setVerticalGroup(
            statisticPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statisticPanelLayout.createSequentialGroup()
                .addComponent(toutPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(empruntesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dateLimitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(reservesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logout.png"))); // NOI18N
        logoutButton.setToolTipText("Deconnexion");
        logoutButton.setFocusable(false);

        emailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/email.png"))); // NOI18N
        emailButton.setToolTipText("Envoyer un email d'alerte");
        emailButton.setEnabled(false);
        emailButton.setFocusable(false);
        emailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailButtonActionPerformed(evt);
            }
        });

        addAdherentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-usr.png"))); // NOI18N
        addAdherentButton.setToolTipText("Ajouter un adherent");
        addAdherentButton.setFocusable(false);
        addAdherentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdherentButtonActionPerformed(evt);
            }
        });

        removeAdherentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/remove-usr.png"))); // NOI18N
        removeAdherentButton.setToolTipText("Supprimer un adherent");
        removeAdherentButton.setEnabled(false);
        removeAdherentButton.setFocusable(false);
        removeAdherentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAdherentButtonActionPerformed(evt);
            }
        });

        addEmployeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add-usr.png"))); // NOI18N
        addEmployeButton.setToolTipText("Ajouter un adherent");
        addEmployeButton.setFocusable(false);
        addEmployeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeButtonActionPerformed(evt);
            }
        });

        removeEmployeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/remove-usr.png"))); // NOI18N
        removeEmployeButton.setToolTipText("Supprimer un adherent");
        removeEmployeButton.setEnabled(false);
        removeEmployeButton.setFocusable(false);
        removeEmployeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeEmployeButtonActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addAdherentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeAdherentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addEmployeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeEmployeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteBookButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addBookButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(makeReservationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(empruntButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(emailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addAdherentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removeAdherentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addEmployeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(removeEmployeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        rechercheTextField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        rechercheTextField.setText("Recherche");

        comboBox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titre", "Auteur", "Editeur" }));
        comboBox.setFocusable(false);

        detailsButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        detailsButton.setText("Détails");
        detailsButton.setEnabled(false);
        detailsButton.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statisticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1591, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1800, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rechercheTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(statisticPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(detailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void makeReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReservationButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_makeReservationButtonActionPerformed

    private void emailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailButtonActionPerformed

    private void addAdherentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdherentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addAdherentButtonActionPerformed

    private void removeAdherentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAdherentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeAdherentButtonActionPerformed

    private void addEmployeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEmployeButtonActionPerformed

    private void removeEmployeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeEmployeButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeEmployeButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdherentButton;
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton addEmployeButton;
    private view.AdherentsView adherentsView;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel dateLimiteNumber;
    private javax.swing.JPanel dateLimitePanel;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JButton detailsButton;
    private javax.swing.JButton emailButton;
    private view.EmployesView employesView;
    private javax.swing.JButton empruntButton;
    private javax.swing.JLabel empruntesNumber;
    private javax.swing.JPanel empruntesPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private view.LivresView livresView;
    private javax.swing.JButton logoutButton;
    private javax.swing.JButton makeReservationButton;
    private javax.swing.JTextField rechercheTextField;
    private javax.swing.JButton removeAdherentButton;
    private javax.swing.JButton removeEmployeButton;
    private javax.swing.JLabel reservesNumber;
    private javax.swing.JPanel reservesPanel;
    private javax.swing.JPanel statisticPanel;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel toutNumber;
    private javax.swing.JPanel toutPanel;
    // End of variables declaration//GEN-END:variables

}
