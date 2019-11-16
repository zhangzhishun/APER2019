package com.springboot.service.doctor.impl;

import com.springboot.dao.user.UserDao;
import com.springboot.domain.User;
import com.springboot.service.doctor.DoctorRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class DoctorRegisterServiceImpl implements DoctorRegisterService {
    @Autowired
    UserDao userDaoImpl;

    @Override
    public int userRegister(User user) {
        if(userDaoImpl.getUserByName(user.getUSER_NAME())==null){
            int result = userDaoImpl.userRegister(user);
            return result;
        }else{
            return -1;
        }
    }

    @Override
    public int checkName(String USER_NAME) {
        if(userDaoImpl.getUserByName(USER_NAME)==null){
            return 1;
        }else{
            return 0;
        }
    }
}
