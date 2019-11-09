package com.springboot.dao.user;

import com.springboot.domain.Admin;
import com.springboot.domain.User;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserDao {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return User
     */
    User getUserByName(String USER_NAME);
}