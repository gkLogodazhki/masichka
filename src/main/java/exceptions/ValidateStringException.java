package exceptions;

public class ValidateStringException extends Exception{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6051858670237135202L;

	public ValidateStringException() {
    }

    public ValidateStringException(String message) {
        super(message);
    }

    public ValidateStringException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateStringException(Throwable cause) {
        super(cause);
    }

    public static String validateString(String str) throws ValidateStringException {
        if (!"".equals(str)){
            return str;
        } else {
            throw new ValidateStringException("invalid format of the input text");
        }
    }
}
