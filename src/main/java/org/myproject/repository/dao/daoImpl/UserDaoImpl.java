package org.myproject.repository.dao.daoImpl;

import org.myproject.repository.dao.hibernateDao.UserDao;
import org.myproject.repository.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDAO")
public class UserDaoImpl extends GenericDaoImpl<User,Long> implements UserDao {

    public UserDaoImpl(){
        super(User.class);
    }
}
