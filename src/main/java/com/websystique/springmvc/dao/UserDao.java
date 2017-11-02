package com.websystique.springmvc.dao;

import com.websystique.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository("userDao")
@Transactional
public class UserDao extends AbstractDao<Integer, User> implements IUserDao {

    static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public User findById(Integer id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getUserType());
            Hibernate.initialize(user.getCity());
        }
        return user;
    }

    public User findBySSO(String sso) {
        logger.info("SSO : {}", sso);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getUserType());
            Hibernate.initialize(user.getCity());
        }
        return user;
    }


    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("firstName"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();
        return users;
    }

    @Override
    public User findByName(String type) {
        return null;
    }

    @Override
    public Optional findByResetToken(String resetToken) {
        return null;
    }

    @Override
    public boolean isSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

    @Override
    public void save(User user) {
        persist(user);
    }

    @Override
    public void deleteBySSO(String sso) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("ssoId", sso));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

}
