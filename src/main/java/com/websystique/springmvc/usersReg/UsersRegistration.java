package com.websystique.springmvc.usersReg;

import com.websystique.springmvc.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Date;


public class UsersRegistration {

    private String firstName;
    private String lastName;
    private String confirmPassword;
    private String phoneNumber;
    private Date date;
    private int userTypeId;
    private int cityId;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws RegistrationException {
        if (firstName == null || firstName.trim().length() < 2) {
            throw new RegistrationException("��������� ���");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws RegistrationException {
        if (firstName == null || lastName.trim().length() < 2) {
            throw new RegistrationException("��������� �������");
        }
        this.lastName = lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws RegistrationException {
        this.phoneNumber = RegistrationException.checkPhoneNumber(phoneNumber);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) throws RegistrationException {
        if (date == null) {
            throw new RegistrationException("��������� ���� �� �������");
        }
        this.date = date;
    }



    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }



}
