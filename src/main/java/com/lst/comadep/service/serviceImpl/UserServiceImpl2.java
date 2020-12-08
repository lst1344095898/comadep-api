package com.lst.comadep.service.serviceImpl;

import com.lst.comadep.Dao.UserDao;
import com.lst.comadep.Entity.User;
import com.lst.comadep.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl2 implements UserService2 {
    final public UserDao userDao;
    @Autowired
    public UserServiceImpl2(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User selectUserById(int id) {

        return userDao.selectUserById(id);
    }
}
