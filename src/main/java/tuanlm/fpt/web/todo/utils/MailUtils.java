package tuanlm.fpt.web.todo.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailUtils {
	public static void sendTextMail(JavaMailSender sender, String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		
		sender.send(message);
	}
}
