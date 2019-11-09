package com.springboot.dao.admin;

import com.springboot.domain.Admin;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdminDao {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Admin
     */
    Admin getAdminByName(String ADMIN_NAME);
}
