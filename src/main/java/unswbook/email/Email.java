package unswbook.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import com.sun.mail.util.MailSSLSocketFactory;

public class Email {

	public void sendEmail(String address, String subject, String contnet) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("mail.debug", "true");
		prop.setProperty("mail.host", "smtp.qq.com");
		prop.setProperty("mail.smtp.auth", "true");
		prop.setProperty("mail.transport.protocol", "smtp");

		MailSSLSocketFactory sf = new MailSSLSocketFactory();
		sf.setTrustAllHosts(true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.ssl.socketFactory", sf);

		Session session = Session.getInstance(prop);
		Transport ts = session.getTransport();
		ts.connect("smtp.qq.com", "UnswBook", "xzukkpyasgukcaec");
		Message message = createSimpleMail(session, address, subject, contnet);
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();
	}

	
	public MimeMessage createSimpleMail(Session session,String address, String subject, String contnet) throws Exception {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress("415563026@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
		message.setSubject(subject);
		message.setContent(contnet, "text/html;charset=UTF-8");
		return message;
	}
}
