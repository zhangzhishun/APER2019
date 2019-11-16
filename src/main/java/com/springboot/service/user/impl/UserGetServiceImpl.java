package com.springboot.service.user.impl;

import com.springboot.dao.user.UserDao;
import com.springboot.domain.User;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class UserGetServiceImpl implements UserGetService {
    @Autowired
    UserDao userDaoImpl;

    @Override
    public Integer getIdByName(String USER_NAME) {
        User userInSql = userDaoImpl.getUserByName(USER_NAME);
        return userInSql.getUSER_ID();
    }

    @Override
    public User getUserByName(String USER_NAME) {
        User userInSql = userDaoImpl.getUserByName(USER_NAME);
        return userInSql;
    }
}
