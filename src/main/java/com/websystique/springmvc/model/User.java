package com.websystique.springmvc.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "sso_id", unique = true, nullable = false)
    @Size(min = 3, max = 30, message = "���� 3 �������")
    private String ssoId;

    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 100, message = "�������� ������ �� ���� ���� 6 �������")
    private String password;

    @NotNull
    @Size(min = 2, max = 50, message = "��������� ���")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50, message = "��������� �������")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "email", nullable = false)
    @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}")
    private String email;

    @NotNull
    @Size(min = 10, max = 10, message = "���� �������� ������� �����")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @NotNull
    @ManyToOne 
    @JoinColumn(name = "user_type_id")
    private UserType userType;

    @Column(name = "reset_token")
    private String resetToken;

    @NotNull
    @ManyToOne 
    @JoinColumn(name = "city_id")
    private City city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getResetToken() {
        return getResetToken();
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!getSsoId().equals(user.getSsoId())) return false;
        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getSsoId().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", ssoId='" + ssoId + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", resetToken='" + resetToken + '\'' +
                ", userType=" + userType +
                ", city=" + city +
                '}';
    }

	
}
