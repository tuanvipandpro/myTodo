/**
 * 
 */
package tuanlm.fpt.web.todo.utils;

import java.util.Random;

/**
 * @author Tuan
 *
 */
public class MathUtils {
	
	/**
	 * Gets the random integer.
	 *
	 * @return the random integer
	 */
	public static int getRandomInteger() {
		int randomNumber = new Random().nextInt(1000000);
		return randomNumber < 100000 ? randomNumber + 100000 : randomNumber;
	}
	
	
}
