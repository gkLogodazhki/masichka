package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.User;

import java.util.Optional;

public interface IUserDao extends IIdNameDao<User> {

    User findBySSO(String sso);

    void save(User user);

    void deleteBySSO(String sso);

    Optional findByResetToken(String resetToken);

    void update(User user);

}

