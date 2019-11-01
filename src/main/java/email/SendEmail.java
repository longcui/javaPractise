package email;// File Name SendEmail.java

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {

   public static void main(String [] args) {    
      // Recipient's email ID needs to be mentioned.
//      String to = "iamlongcui@gmail.com";
      String to = "long@origin.no";

      // Sender's email ID needs to be mentioned
//      String from = "web@gmail.com";
      String from = "long@origin.no";

      // Assuming you are sending email from localhost
      String host = "smtp.sendgrid.net";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      properties.put("mail.smtp.auth", "true");
      properties.put("mail.smtp.port", "587");

      // Create an authenticator object
      Authenticator auth = new Authenticator() {
         @Override
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("apikey", "find in one drive");
         }
      };

      // Get the default Session object.
      Session session = Session.getInstance(properties, auth);

      try {
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");

         // Now set the actual message
         message.setText("This is actual message");

         // Send message
         Transport.send(message);
         System.out.println("Sent message successfully....");
      } catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}