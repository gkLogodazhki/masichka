package users;

import java.sql.Date;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;

import exceptions.ValidateEmailPasswordException;
import exceptions.ValidateStringException;

public class UsersPOJO {
	/*
	table users:
		id  INT AL PK
		mail VARCHAR(45)
		pass VARCHAR(45)
		first_name VARCHAR(45)
		last_name VARCHAR(45)
		phone_number VARCHAR(45)
		birthday DATE
		agree_with_general_terms TINYINT(3)
		want_notifications TINYINT(3)
		user_type_id INT FK
		city_id INT FK
	 */
	
	private String mail;
	private String pass;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private LocalDate date;
	private boolean isAgree;
	private boolean wantNotification;
//	private int userTypeId;
//	private int cityId;
	
	public UsersPOJO() {
		
	}
	
	public UsersPOJO(String mail, String pass, String firstName, String lastName, String phoneNumber
			, LocalDate date, boolean isAgree, boolean wantNotification) throws ValidateStringException, ParseException, ValidateEmailPasswordException {
		setMail(mail);
		setPass(pass);
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setDate(date);
		setAgree(isAgree);
		setWantNotification(wantNotification);
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) throws ValidateEmailPasswordException {
		this.mail = ValidateEmailPasswordException.validateEmail(mail);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) throws ValidateEmailPasswordException {
		this.pass = ValidateEmailPasswordException.validatePassword(pass);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws ValidateStringException {
		this.firstName = ValidateStringException.validateString(firstName);
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws ValidateStringException {
		this.lastName = ValidateStringException.validateString(lastName);
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws ValidateStringException {
		this.phoneNumber = ValidateStringException.validateString(phoneNumber);
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) throws ParseException {
		try {
			this.date = date;
		}catch(DateTimeException e) {
			throw new ParseException("ILLEGAL DATE", 0);
		}
	}

	public boolean isAgree() {
		return isAgree;
	}

	public void setAgree(boolean isAgree) {
		this.isAgree = isAgree;
	}

	public boolean isWantNotification() {
		return wantNotification;
	}

	public void setWantNotification(boolean wantNotification) {
		this.wantNotification = wantNotification;
	}

	
}
