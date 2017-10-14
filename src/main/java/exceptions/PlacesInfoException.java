package exceptions;

public class PlacesInfoException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4533034297907937282L;

	public PlacesInfoException() {
    }

    public PlacesInfoException(String message) {
        super(message);
    }

    public PlacesInfoException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlacesInfoException(Throwable cause) {
        super(cause);
    }
}
