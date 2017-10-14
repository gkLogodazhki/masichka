package users;

import exceptions.ValidateEmailPasswordException;

public abstract class UserInfo {
	private String mail;
	private String pass;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String mail, String pass) throws ValidateEmailPasswordException {
		setMail(mail);
		setPass(pass);
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
	
	
}
