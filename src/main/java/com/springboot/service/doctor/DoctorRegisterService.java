package com.springboot.service.doctor;

import com.springboot.domain.User;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorRegisterService {
    /**
     * 用户注册
     * @return int
     * */
    int userRegister(User user);

    /**
     * 检查用户名是否可用
     * @return int
     * */
    int checkName(String USER_NAME);

}
