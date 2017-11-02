package com.websystique.springmvc.usersReg;

import com.websystique.springmvc.exception.RegistrationException;

public abstract class UserInfo {

    private String email;
    private String pass;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws RegistrationException {
        this.email = RegistrationException.checkEmail(email);
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) throws RegistrationException {
        this.pass = RegistrationException.checkPassword(pass);
    }

    @Override
    public String toString() {
        return "UserInfo [email=" + email + ", pass=" + pass + "]";
    }


}
