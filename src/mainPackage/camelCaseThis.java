package mainPackage;

public class camelCaseThis {

	static String camelCase(String text) {
		boolean shouldConvertNextCharToLower = true;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
		    char currentChar = text.charAt(i);
		    if (currentChar == ' ') {
		        shouldConvertNextCharToLower = false;
		    } else if (shouldConvertNextCharToLower) {
		        builder.append(Character.toLowerCase(currentChar));
		    } else {
		        builder.append(Character.toUpperCase(currentChar));
		        shouldConvertNextCharToLower = true;
		    }
		}
		return builder.toString();
	}
	
}
