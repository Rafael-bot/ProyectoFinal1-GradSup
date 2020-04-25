package ProPlay.Clases.Email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Email {
	
	private Properties props = new Properties();
	private String micorreo = "proplayit.company@gmail.com";
	private String micontra = "proplayitcomp123";
	private String asunto;
	private String mensaje;
	
	private void conexemail() {
		// Nombre del host de correo, es smtp.gmail.com
		props.setProperty("mail.smtp.host", "smtp.gmail.com");

		// TLS si está disponible
		props.setProperty("mail.smtp.starttls.enable", "true");

		// Puerto de gmail para envio de correos
		props.setProperty("mail.smtp.port", "587");

		// Si requiere o no usuario y password para conectarse.
		props.setProperty("mail.smtp.auth", "true");
	}
	
	public void envRegister(String destinatario,String user) {
		
		conexemail();
		
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		
		asunto = "Bienvenido";
		mensaje = "Hola "+user+". \nGracias por unirte a nuestra gran familia.";
		
		MimeMessage mail = new MimeMessage(session);
		try {
		
			mail.setFrom(new InternetAddress());
			mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mail.setSubject(asunto);
			mail.setText(mensaje);
			
			Transport transporte = session.getTransport("smtp");
			transporte.connect(micorreo,micontra);
			transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
			transporte.close();
		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
