package com.websystique.springmvc.model;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "sso_id", unique = true, nullable = false)
    @Size(min = 3, max = 30, message = "size must be between 3 and 30")
    private String ssoId;

    @Column(name = "password", nullable = false)
    @Size(min = 6, max = 100, message = "size must be between 6 and 100")
    private String password;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "email", nullable = false)
    @Email(message = "not a valid email")
    @Pattern(regexp = "[A-Za-z0-9._%-+]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}", message = "not a valid")
    private String email;

//    @Column(name = "reset_token")
//    private String resetToken;


    @NotNull
    @ManyToOne
    @Column(name = "reset_token")
    private String resetToken;

    @NotNull
    @Column(name = "phone_number", nullable = false, length = 10)
    private String phoneNumber;
    
    
    @NotNull
    @ManyToOne 
    @JoinColumn(name = "user_type_id")
    private UserType userType;

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

//    public String getResetToken() {
//        return resetToken;
//    }
//
//    public void setResetToken(String resetToken) {
//        this.resetToken = resetToken;
//    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		String configuredNumer = "0" + phoneNumber.substring(6);
		this.phoneNumber = configuredNumer;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ssoId=" + ssoId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", resetToken=" + resetToken + ", phoneNumber="
				+ phoneNumber + ", userType=" + userType + ", city=" + city + "]";
	}
	
}
