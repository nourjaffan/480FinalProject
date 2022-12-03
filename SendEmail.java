import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
/** 
 * This class is used to send simple email 
 * via Gmail server using TLS connection. 
 *   @author w3spoint
 */ 
public class SendEmail { 
final String senderEmailId = "sendingEmail@gmail.com";
final String senderPassword = "twoFactorAppPass";
final String emailSMTPserver = "smtp.gmail.com";
final String emailSMTPPort = "587";
 
public SendEmail (String receiverEmail, 
		String subject, String messageText) {		
	Properties props = new Properties(); 
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	props.put("mail.smtp.auth", "true"); 
	props.put("mail.smtp.starttls.enable", "true"); 
	props.put("mail.smtp.host", emailSMTPserver); 
	props.put("mail.smtp.port", emailSMTPPort); 
 
 try { 			
	Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getInstance(props, auth);
	Message message = new MimeMessage(session);
	message.setFrom(new InternetAddress(senderEmailId));
	message.setRecipients(Message.RecipientType.TO, 
			InternetAddress.parse(receiverEmail));
	message.setSubject(subject);
	message.setText(messageText);
 
	Transport.send(message); 
	System.out.println("Email send successfully."); 
 } catch (Exception e) {
	e.printStackTrace();
    System.err.println("Error in sending email.");
  }
}
 
private class SMTPAuthenticator extends 
  javax.mail.Authenticator {
    public PasswordAuthentication 
      getPasswordAuthentication() {
        return new PasswordAuthentication(senderEmailId, 
        		senderPassword);
    }
}
 
public static void main(String[] args) {
	new SendEmail ("receivingEmail@gmail.com", 
			"Test Email", "Hi,\n\n This is a test email via " +
				"Gmail server using TLS connection.");
}
}
