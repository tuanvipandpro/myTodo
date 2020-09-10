/**
 * 
 */
package tuanlm.fpt.web.todo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// TODO: Auto-generated Javadoc
/**
 * The Class EncodeUtils.
 *
 * @author Admin
 */
public class EncodeUtils {
	
	/**
	 * Encryte password.
	 *
	 * @param password the password
	 * @return the string
	 */
	public static String encrytePassword(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}
}
