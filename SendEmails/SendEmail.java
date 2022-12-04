package SendEmails;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * This class is used to send simple email
 * via Gmail server using TLS connection.
 * 
 * @author w3spoint
 */
public class SendEmail {
	final String senderEmailId = "xwei.low@gmail.com";
	final String senderPassword = "ojlfhlpztyamwllr";
	final String emailSMTPserver = "smtp.gmail.com";
	final String emailSMTPPort = "587";

	public SendEmail(String receiverEmail,
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class SMTPAuthenticator extends
			javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(senderEmailId,
					senderPassword);
		}
	}

}