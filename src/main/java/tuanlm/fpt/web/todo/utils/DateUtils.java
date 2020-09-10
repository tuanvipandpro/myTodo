package tuanlm.fpt.web.todo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DateUtils.
 */
public class DateUtils {
	public static Date DateConvert(String dateString, String format) throws ParseException {
		// Check null or empty
		if (dateString.isBlank() || dateString == null) {
			return null;
		}
		
		return new SimpleDateFormat(format).parse(dateString);
	}
}
