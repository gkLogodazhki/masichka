package com.websystique.springmvc.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -1566094279628877844L;
    private static final String EMAIL_REGEX = "[A-Za-z0-9._%-+]+@[A-Za-z0-9]+\\\\.[A-Za-z]{2,4}";


    public RegistrationException() {
        super();
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistrationException(String message) {
        super(message);
    }

    public RegistrationException(Throwable cause) {
        super(cause);
    }

    public static String checkPassword(String password) throws RegistrationException {
        if (password == null || password.trim().length() < 8) {
            throw new RegistrationException("Невалидна парола");
        }
        return password;

    }

    public static String checkPhoneNumber(String phoneNumber) throws RegistrationException {
        if (phoneNumber == null || !phoneNumber.startsWith("(+359)")
                || phoneNumber.trim().length() != 15) {
            throw new RegistrationException("Телефонният номер трябва да бъде "
                    + "във формат (+359)*********");
        }

        String validNumber = "0" + phoneNumber.substring(6);
        return validNumber;
    }

    public static String checkEmail(String email) throws RegistrationException {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher("email");
        if (!matcher.find()) {
            throw new RegistrationException("Невалиден email");
        }
        return email;
    }


}
