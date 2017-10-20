package usersLogin;

import exceptions.ValidateEmailPasswordException;
import usersReg.UserInfo;

public class LoginPOJO extends UserInfo{
	
	public LoginPOJO(String mail, String pass) throws ValidateEmailPasswordException {
		super(mail,pass);
	}
	
}
