
package controller.GUI;

import View.LoginView;
import controller.CRUD.AdherentsCRUD;
import controller.CRUD.EmployesCRUD;
import controller.MainClass;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import model.Adherent;
import model.Employe;

public class LoginController {
    private final LoginView loginView;
    private final Connection connexion;
    private final AdherentsCRUD adherentsCrud;
    private final EmployesCRUD employesCrud;

    public LoginController(Connection connexion) {
        this.loginView = new LoginView();
        this.connexion = connexion;
        this.adherentsCrud = new AdherentsCRUD(this.connexion);
        this.employesCrud = new EmployesCRUD(this.connexion);
        
        initView();
        initController();
    }
    
    public LoginView getLoginView(){
        return loginView;
    }
    
    private void initView(){
        loginView.getExistLabel().setVisible(false);
        loginView.getIciLabel().setVisible(false);
        reset();
    }
    
    private void initController(){
        loginView.getConnectButton().addActionListener(e -> login());
        
        loginView.getResetButton().addActionListener(e -> reset());
        
        loginView.getLoginTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                if(loginView.getLoginTextField().getText().equals("Login")){
                    loginView.getLoginTextField().setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(loginView.getLoginTextField().getText().isEmpty())
                    loginView.getLoginTextField().setText("Login");
            }
        });
        loginView.getLoginTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                ((JPanel)loginView.getLoginTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        
        loginView.getMdpTextField().addFocusListener(new FocusListener(){
            @Override
            public void focusGained(FocusEvent e) {
                String mdp=String.valueOf(loginView.getMdpTextField().getPassword());
                if(mdp.equals("Mot de passe")){
                    loginView.getMdpTextField().setEchoChar('\u25CF');
                    loginView.getMdpTextField().setText("");
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
        loginView.getMdpTextField().addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                ((JPanel)loginView.getMdpTextField().getParent()).setBorder(BorderFactory.createEmptyBorder());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        
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
        loginView.getLoginTextField().setText("Login");
        loginView.getMdpTextField().setEchoChar((char)0);
        loginView.getMdpTextField().setText("Mot de passe");
    }
    
    public void login(){
        String mdp=String.valueOf(loginView.getMdpTextField().getPassword());
        String login=loginView.getLoginTextField().getText();
        if(mdp.isEmpty() || mdp.equals("Mot de passe")){
            ((JPanel)loginView.getMdpTextField().getParent()).setBorder(BorderFactory.createLineBorder(Color.red));
            if(login.isEmpty() || login.equals("Login")){
                ((JPanel)loginView.getLoginTextField().getParent()).setBorder(BorderFactory.createLineBorder(Color.red));
            }
        }else{
            Adherent adherent=adherentsCrud.getAdherentBy(login, mdp);
            if(adherent!=null){
                MainClass.generalController.toNextView();
            }else{
                Employe employe=employesCrud.getEmployeBy(login, mdp);
                if(employe!=null){
                    MainClass.generalController.toNextView();
                }else{
                    loginView.getExistLabel().setVisible(true);
                    loginView.getIciLabel().setVisible(true);
                }
            }
        }
    }
}
