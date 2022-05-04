package database;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public abstract class MailSender {

	public static void sendMail(String recEmail, String subject, String body) {
		String email = "***********";
		String password = "********";
		
		Properties theProperties = new Properties();
		
		theProperties.put("mail.smtp.auth", "true");
		theProperties.put("mail.smtp.starttls.enable", "true");
		theProperties.put("mail.smtp.host", "smtp.gmail.com");
		theProperties.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(theProperties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recEmail));
			message.setSubject(subject);
			message.setText(body
					+ "\n\nFor any query please contact: ratul.sunny111@gmail.com");
			
			Transport.send(message);
			
			System.out.println("Successfully sent Verification Link");
			
		} catch (Exception e) {
			System.out.println("Error at SendingEmail.java: " + e);
		}
		
	}
 }	
