package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmailPasswordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2725467544046374779L;
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static final Pattern VALID_PASSWORD = 
			Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$");
	
	public ValidateEmailPasswordException() {
		super();
	}

	public ValidateEmailPasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateEmailPasswordException(String message) {
		super(message);
	}

	public ValidateEmailPasswordException(Throwable cause) {
		super(cause);
	}

	public static String validateEmail(String mail) throws ValidateEmailPasswordException {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
		if(matcher.find()) {
			return mail;
		}
		throw new ValidateEmailPasswordException("Incorrect email address");
	}

	public static String validatePassword(String pass) throws ValidateEmailPasswordException {
		Matcher matcher = VALID_PASSWORD.matcher(pass);
		if(matcher.find()) {
			return pass;
		}
		throw new ValidateEmailPasswordException("Incorrect password");
	}

}
