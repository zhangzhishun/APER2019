package com.springboot.service.user;

import com.springboot.domain.User;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface UserGetService {
    /**
     * 根据USER_NAME获取USER_ID
     * @return boolean
     * */
    Integer getIdByName(String USER_NAME);

}
