package beans;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class EnviarMail {
	public  void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente tambi�n.
	    String remitente = "tiendagertech@gmail.com";  //Para la direcci�n nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "miClaveDeGMail");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticaci�n mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    session.setDebug(true);
	    MimeMessage message = new MimeMessage(session);
	    
	    
	    try {
	    	BodyPart messageBP = new MimeBodyPart();
		    messageBP.setContent(cuerpo,"text/html");
		    Multipart mPart = new MimeMultipart();
		    mPart.addBodyPart(messageBP);
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podr�an a�adir varios de la misma manera
	        message.setSubject(asunto);
	        message.setContent(mPart);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "gapc24220358");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
}
