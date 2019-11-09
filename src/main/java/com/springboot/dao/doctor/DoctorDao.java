package com.springboot.dao.doctor;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorDao {

    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Doctor
     */
    Doctor getDoctorByName(String DOCTOR_NAME);
}
