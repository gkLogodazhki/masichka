package exceptions;

public class PlacesInfoException extends Exception {
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
