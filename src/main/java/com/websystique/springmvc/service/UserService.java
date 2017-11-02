package com.websystique.springmvc.service;

import com.websystique.springmvc.dao.IUserDao;
import com.websystique.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service("userService")
@Transactional
public class UserService implements IUserDao {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User findBySSO(String sso) {
        return userDao.findBySSO(sso);
    }

    @Override
    public Optional findByResetToken(String resetToken) {
        return userDao.findByResetToken(resetToken);
    }

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    @Override
    public void update(User user) {
        User entity = userDao.findById(user.getId());
        if (entity != null) {
            entity.setSsoId(user.getSsoId());
            if (!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
            entity.setUserType(user.getUserType());
            entity.setCity(user.getCity());
        }
    }

    @Override
    public void deleteBySSO(String sso) {
        userDao.deleteBySSO(sso);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByName(String type) {
        return userDao.findByName(type);
    }

    @Override
    public boolean isSSOUnique(Integer id, String sso) {
        User user = userDao.findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

}
