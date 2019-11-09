package com.springboot.dao.admin;

import com.springboot.domain.Admin;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminDao {

    /**
     * 更新数据库表
     * @return String
     */
    Admin getPassword(String ADMIN_NAME);
}
