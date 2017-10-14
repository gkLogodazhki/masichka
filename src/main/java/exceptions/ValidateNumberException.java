package exceptions;

public class ValidateNumberException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3272630105748228318L;
	public ValidateNumberException() {
    }

    public ValidateNumberException(String message) {
        super(message);
    }

    public ValidateNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidateNumberException(Throwable cause) {
        super(cause);
    }

    public static int validateInteger(int number, int min, int limit) throws ValidateNumberException {
        if (number >= min && number <= limit){
            return number;
        } else {
            throw new ValidateNumberException("number out of bounds");
        }
    }
    public static float validateFloat(float number, float min, float limit) throws ValidateNumberException {
        if (number >= min && number <= limit){
            return number;
        } else {
            throw new ValidateNumberException("number out of bounds");
        }
    }


}
