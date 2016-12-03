
package controller;

import view.LoginView;
import model.CRUD.AdherentsCRUD;
import model.CRUD.EmployesCRUD;
import controller.main.MainClass;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import model.entities.Adherent;
import model.entities.Employe;

public class LoginController {
    private final LoginView loginView;
    private final Connection connexion;
    private final AdherentsCRUD adherentsCrud;
    private final EmployesCRUD employesCrud;

    public LoginController(Connection connexion) {
        this.loginView = new LoginView();
        this.connexion = connexion;
        this.adherentsCrud = new AdherentsCRUD(this.connexion, null);
        this.employesCrud = new EmployesCRUD(this.connexion, null);
        
        initView();
        initController();
    }
    
    public LoginView getLoginView(){
        return loginView;
    }
    
    private void initView(){
        loginView.getLoaderPanel().setVisible(false);
        hideErrorMessage();
        reset();
    }
    
    private void initController(){
        loginView.getConnectButton().addActionListener(e -> new Thread(()->login()).start());
        
        loginView.getResetButton().addActionListener(e -> reset());
        
        loginView.getLoginTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if(loginView.getLoginTextField().getText().equals("Login")){
                    loginView.getLoginTextField().setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(loginView.getLoginTextField().getText().isEmpty())
                    loginView.getLoginTextField().setText("Login");
            }
        });
        loginView.getLoginTextField().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(loginView.getLoginTextField().getText().equals("Login"))
                    loginView.getLoginTextField().setCaretPosition(0);
            }
        });
        loginView.getLoginTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if(loginView.getLoginTextField().getText().equals("Login")){
                    loginView.getLoginTextField().setText("");
                }
                hideErrorMessage();
                ((JPanel)loginView.getLoginTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(loginView.getLoginTextField().getText().isEmpty()){
                    loginView.getLoginTextField().setText("Login");
                    loginView.getLoginTextField().setCaretPosition(0);
                }
            }
        });
        
        loginView.getMdpTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                String mdp=String.valueOf(loginView.getMdpTextField().getPassword());
                if(mdp.equals("Mot de passe")){
                    loginView.getMdpTextField().setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(String.valueOf(loginView.getMdpTextField().getPassword()).isEmpty()){
                    loginView.getMdpTextField().setEchoChar((char)0);
                    loginView.getMdpTextField().setText("Mot de passe");
                }
            }
        });
        loginView.getMdpTextField().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if(String.valueOf(loginView.getMdpTextField().getPassword()).equals("Mot de passe"))
                    loginView.getMdpTextField().setCaretPosition(0);
            }
        });
        loginView.getMdpTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                String mdp=String.valueOf(loginView.getMdpTextField().getPassword());
                if(mdp.equals("Mot de passe")){
                    loginView.getMdpTextField().setEchoChar('\u25CF');
                    loginView.getMdpTextField().setText("");
                }
                hideErrorMessage();
                ((JPanel)loginView.getMdpTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(loginView.getMdpTextField().getPassword().length==0){
                    loginView.getMdpTextField().setEchoChar((char)0);
                    loginView.getMdpTextField().setText("Mot de passe");
                    loginView.getMdpTextField().setCaretPosition(0);
                }
            }
        
        });
        
        loginView.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                loginView.grabFocus();
            }
        });
        
        loginView.getIciLabel().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseReleased(e);
                hideErrorMessage();
                reset();
                new PasswordResetController(connexion);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginView.getIciLabel().setForeground(Color.decode("#3366FF"));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginView.getIciLabel().setForeground(Color.decode("#0099FF"));
            }
        });
    }
    
    private void reset(){
        ((JPanel)loginView.getMdpTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
        ((JPanel)loginView.getLoginTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
        loginView.getLoginTextField().setText("Login");
        loginView.getMdpTextField().setEchoChar((char)0);
        loginView.getMdpTextField().setText("Mot de passe");
    }
    
    private void showErrorMessage(){
        loginView.getExistLabel().setVisible(true);
        loginView.getExistLabel2().setVisible(true);
        loginView.getIciLabel().setVisible(true);
    }
    
    private void hideErrorMessage(){
        loginView.getExistLabel().setVisible(false);
        loginView.getExistLabel2().setVisible(false);
        loginView.getIciLabel().setVisible(false);
    }
    
    public void login(){
        loginView.getLoaderPanel().setVisible(true);
        String mdp=String.valueOf(loginView.getMdpTextField().getPassword());
        String login=loginView.getLoginTextField().getText();
        boolean mdpEmpty=false, loginEmpty=false;
        
        if(mdp.isEmpty() || mdp.equals("Mot de passe")){
            loginView.getLoaderPanel().setVisible(false);
            ((JPanel)loginView.getMdpTextField().getParent()).setBorder(BorderFactory.createLineBorder(Color.red));
            mdpEmpty=true;
        }
        if(login.isEmpty() || login.equals("Login")){
            loginView.getLoaderPanel().setVisible(false);
            ((JPanel)loginView.getLoginTextField().getParent()).setBorder(BorderFactory.createLineBorder(Color.red));
            loginEmpty=true;
        }
        if(!mdpEmpty && !loginEmpty){
            if(login.equals("Admin") && mdp.equals("Admin")){
                loginView.getLoaderPanel().setVisible(false);
                reset();
                MainClass.generalController.toNextView(1);
            }else{
                Adherent adherent=adherentsCrud.getAdherentBy(login, mdp);
                if(adherent!=null){
                    loginView.getLoaderPanel().setVisible(false);
                    reset();
                    MainClass.generalController.toNextView(2);
                }else{
                    Employe employe=employesCrud.getEmployeBy(login, mdp);
                    if(employe!=null){
                        loginView.getLoaderPanel().setVisible(false);
                        reset();
                        MainClass.generalController.toNextView(3);
                    }else{
                        loginView.getLoaderPanel().setVisible(false);
                        showErrorMessage();
                    }
                }
            }
        }
    }
}
