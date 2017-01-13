package gestioneUtente;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtilityReset {
	
	
	public static void sendEmail(String host, String port,
			final String userName, final String password, String toAddress,String passwordUtente) throws AddressException,MessagingException {

		// sets SMTP server properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");

		// creates a new session with an authenticator
		
		Session session = Session.getInstance(properties,  
				 new javax.mail.Authenticator() {  
				  protected PasswordAuthentication getPasswordAuthentication() {  
					  System.out.println("AUTENTICANDO.."+userName+" "+password);
					  return new PasswordAuthentication(userName,password);  
				   }  
				});
			
		//crypt
		
		
		String param = EncryptionUtil.encode("password="+passwordUtente+"&email="+toAddress);

		// creates a new e-mail message
		String url = "http://localhost:8080/usu/ResetPassword?q="+param;
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject("Password StudentUtilities");
		msg.setContent("Nuova password: "+passwordUtente+"<a href='"+url+"'>Conferma</a>","text/html");
		msg.setSentDate(new Date());

		// sends the e-mail
		Transport.send(msg);


}
}