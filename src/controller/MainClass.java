
package controller;

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
            String url = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8145007";
            String user = "sql8145007";
            String mdp="xysgX4HhML";
            
            connexion = DriverManager.getConnection(url, user, mdp);
            return connexion;
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public static boolean sendMail(String adresse,String object,String message){
        try{
            /* L'adresse IP de votre serveur SMTP */
            String host = "smtp.gmail.com";
            String user="oumayma.habouri@gmail.com";
            String pass="14761952";
            String from = "oumayma.habouri@gmail.com";
            String to = adresse; 
            String objet = object;
            String texte = message;
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
        }
    catch (AddressException e) {
            e.printStackTrace();
            return(false);
        } 
    catch (MessagingException e) {
            e.printStackTrace();
            return(false);
        } 
         
    
    }
    
    public static void main(String args[]){
        Connection connexion;
        connexion=makeConnection();
        if(connexion!=null){
            generalController=new GeneralController(connexion);
        }
        sendMail("m.abdennadher.seif@gmail.com","mail","ok");
    }
    
    
    public static boolean isValidEmail(String email){
        String pattern="^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p=Pattern.compile(pattern);
        Matcher m=p.matcher(email);
        return m.matches();
    }
}
