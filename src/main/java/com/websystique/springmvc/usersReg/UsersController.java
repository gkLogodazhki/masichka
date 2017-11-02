package com.websystique.springmvc.usersReg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

@Controller
public class UsersController {
    private static final String INSERT_INTO_USERS_REG = "insert into users_reg values"
            + "(null,?,?,?,?,?,?,?,?,?,?)";
    @Autowired
    private DBManager db;

    @Autowired
    private UsersRegistration user;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String goToRegistration() {
        return "/Register";
    }


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String makeRegistration(@RequestParam(value = "first_name") String firstName
            , @RequestParam(value = "last_name") String lastName
            , @RequestParam int city, @RequestParam(value = "user_password") String password
            , @RequestParam(value = "confirm_password") String confirmPassword
            , @RequestParam String email, @RequestParam(value = "contact_no") String phoneNumber
            , @RequestParam String day, @RequestParam String month
            , @RequestParam String year
                                   //,@RequestParam String securityCode
                                   //,@RequestParam String userSecutityCode
            , @RequestParam String agreeCondition
            , @RequestParam boolean wantNotifications) {
        try {
            @SuppressWarnings("deprecation")
            Date date = new Date(Integer.parseInt(year), Integer.parseInt(month)
                    , Integer.parseInt(day));
            user.setUserTypeId(2);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPass(password);
            user.setConfirmPassword(confirmPassword);
            user.setPhoneNumber(phoneNumber);
            user.setDate(date);
            user.setAgree(agreeCondition);
            user.setWantNotification(wantNotifications);
            user.setPhotoPath("path comes here");
            user.setCityId(city);

            Connection conn = db.getConnection();
            PreparedStatement stmt = conn.prepareStatement(INSERT_INTO_USERS_REG);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getPass());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getPhotoPath());
            stmt.setDate(6, (Date) user.getDate());
            stmt.setBoolean(7, user.isAgree());
            stmt.setBoolean(8, user.isWantNotification());
            stmt.setInt(9, user.getUserTypeId());
            stmt.setInt(10, user.getCityId());

            stmt.executeUpdate();

        } catch (Exception e) {
            return "/Register";
        }
        return "/Register";
    }


}
