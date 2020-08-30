/**
 * 
 */
package tuanlm.fpt.web.todo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Admin
 *
 */
public class EncodeUtils {
	public static String encrytePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
}
