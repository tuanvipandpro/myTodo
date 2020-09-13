package tuanlm.fpt.web.todo.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

// TODO: Auto-generated Javadoc
/**
 * The Class MailUtils.
 */
public class MailUtils {
	
	/**
	 * Send text mail.
	 *
	 * @param sender the sender
	 * @param to the to
	 * @param subject the subject
	 * @param content the content
	 */
	public static void sendTextMail(JavaMailSender sender, String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		
		sender.send(message);
	}
}
