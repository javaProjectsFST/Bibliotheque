
package controller.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPanel;

public class MainClass extends JPanel{
    public static Connection connexion;
    public static GeneralController generalController;
    
    static Connection makeConnection(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //Connection to localhost:3306
//            String url = "jdbc:mysql://localhost:3306/bibliotheque";
//            String user = "root";
//            String mdp="";
            
            //Connection to hosted database
            String url = "jdbc:mysql://seif.sytes.net:3306/Bibliotheque";
            String user = "root";
            String mdp="root";
            
            connexion = DriverManager.getConnection(url, user, mdp);
            return connexion;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static void main(String args[]){
        Connection connexion;
        connexion=makeConnection();
        if(connexion!=null){
            generalController=new GeneralController(connexion);
        }
    }
    
    public static boolean sendMail(String adresse,String object,String message){
        try{
            String footer="\n\nCe message a été généré et transmis automatiquement, merci de ne pas répondre.\nCordialement.\n\n--Service Bibliotheque.";
            String host = "smtp.gmail.com";
            String user="java.bibliotheque@gmail.com";
            String pass="amr.seif.oumayma";
            String from = "java.bibliotheque@gmail.com";
            String to = adresse; 
            String objet = object;
            String texte = message+footer;
            boolean sessionDebug=false;
            
            Properties props = System.getProperties();
            props.put("mail.smtp.starttls.enable","true");
            props.put("mail.smtp.ssl.trust",host);
            props.put("mail.smtp.port","587");
            props.put("mail.smtp.auth","true");
            props.put("mail.smtp.starttls required","true");
           
            /* Session encapsule pour un client donné sa connexion avec le serveur de mails.*/
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(sessionDebug);
            
            /* Création du message*/
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address={new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO,address);
            msg.setSubject(objet);
            msg.setText(texte);
            msg.setHeader("X-Mailer", "LOTONtechEmail");
            Transport transport=session.getTransport("smtp");
            transport.connect(host,user,pass);
            transport.sendMessage(msg,msg.getAllRecipients());
            transport.close();
            return(true);
        }catch (AddressException e) {
            e.printStackTrace();
            return(false);
        }catch (MessagingException e) {
            e.printStackTrace();
            return(false);
        }
    }
    
    public static boolean isValidEmail(String email){
        String pattern="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(email);
        return m.matches();
    }
}
