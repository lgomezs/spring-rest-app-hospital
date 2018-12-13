package pe.com.hospital.util;

public class StringUtil {

	public static String toCamelCase(String value) {
		String result = "";
		
		if (value == null || value.equals("")) {
			return result;
		}

		value = value.trim().toLowerCase();

		String[] values = value.split(" ");

		for (String val : values) {

			String firstLetter = val.substring(0, 1);
			firstLetter = firstLetter.toUpperCase();
			String sub = firstLetter.concat(val.substring(1, val.length()));
			result = result + sub + " ";
		}

		return result;
	}
	
	
}
