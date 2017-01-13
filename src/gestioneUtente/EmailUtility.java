package gestioneUtente;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtility {
	/**
	 * @author Pasquale Settembre
	 * <b>Permette l'invio di una email</b>
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 * @param toAddress
	 * @param subject
	 * @param message
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendEmail(String host, String port,
			final String userName, final String password, String toAddress,String nome,String cognome,String passwordUtente) throws AddressException,MessagingException {

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
			
		//Crypt
		String param = EncryptionUtil.encode("nome="+nome+"&cognome="+cognome+"&email="+toAddress+"&password="+passwordUtente);
		

		
		
		// creates a new e-mail message
		Message msg = new MimeMessage(session);
		
		String url = "http://localhost:8080/usu/RegistrazioneUtente?q="+param;
		
		//html
		String html="<html>"
				
		+"<head>"
		+"<title></title>"
		+"<style type=\"text/css\">"
		+"@media (min-width:320px)  { /* smartphones, iPhone, portrait 480x320 phones */ body{width: auto !important;}p{font-weight: 1em;}"
		+"@media (min-width:481px)  { /* portrait e-readers (Nook/Kindle), smaller tablets @ 600 or @ 640 wide. */ body{width: auto !important;}}"
		+"@media (min-width:641px)  { /* portrait tablets, portrait iPad, landscape e-readers, landscape 800x480 or 854x480 phones */ body{width: auto !important;}}"
		+"@media (min-width:961px)  { /* tablet, landscape iPad, lo-res laptops ands desktops */ body{width: auto !important;}}"
		+"@media (min-width:1025px) { /* big landscape tablets, laptops, and desktops */ body{width: auto !important;}}"
		+"@media (min-width:1281px) { /* hi-res laptops and desktops */ body{width: auto !important;}}"
		+"</style>"
		+"</head>"
		+"<body>"
		+"<div style=\"border:2px solid black; padding: 10px\">"
		+"<img src=\"https://s30.postimg.org/4kyftzqr5/logo.png\" style=\"display: block; margin: 0 auto\"><strong>"
		+"<hr>"
		+"<p>Per completare la registrazione si prega di cliccare su:<p>"
		+"<a href="+url+">Coferma registrazione.</a>"
		+"</div>"
		+"</body>"
		+"</html>";
		
		
		msg.setFrom(new InternetAddress(userName));
		InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject("Conferma registrazione StudentUtilities");
		msg.setContent(html,"text/html");
		msg.setSentDate(new Date());

		// sends the e-mail
		Transport.send(msg);

	}
}
