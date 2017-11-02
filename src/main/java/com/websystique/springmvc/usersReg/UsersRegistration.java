package com.websystique.springmvc.usersReg;

import com.websystique.springmvc.exception.RegistrationException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsersRegistration extends UserInfo {

    private String firstName;
    private String lastName;
    private String confirmPassword;
    private String phoneNumber;
    private Date date;
    private int userTypeId;
    private int cityId;
    private String photoPath;
    private boolean isAgree;
    private boolean wantNotification;


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

    public void setConfirmPassword(String confirmPassword) throws RegistrationException {
        if (confirmPassword == null || !confirmPassword.equals(getPass())) {
            throw new RegistrationException("�������� �� ��������");
        }
        this.confirmPassword = confirmPassword;
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

    public boolean isAgree() {
        return isAgree;
    }

    public void setAgree(String agree) throws RegistrationException {
        if (agree == null || !agree.equals("1")) {
            throw new RegistrationException("�� �� �� ������������ ������ �� "
                    + "��� �������� � ������ �������");
        }
        this.isAgree = true;
    }

    public boolean isWantNotification() {
        return wantNotification;
    }

    public void setWantNotification(boolean wantNotification) {
        this.wantNotification = wantNotification;
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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) throws RegistrationException {
        if (photoPath == null || !photoPath.substring(photoPath.length() - 4).contains("jpg")) {
            throw new RegistrationException("�������� ������ �� ���� � jpg ������");
        }
        this.photoPath = photoPath;
    }

    @Override
    public String toString() {
        return "UsersRegistration [firstName=" + firstName + ", lastName=" + lastName
                + ", confirmPassword=" + confirmPassword + ", phoneNumber="
                + phoneNumber + ", date=" + date + ", isAgree=" + isAgree + ", wantNotification=" + wantNotification
                + ", userTypeId=" + userTypeId + ", cityId=" + cityId + ", photoPath=" + getPhotoPath() + "]";
    }


}
