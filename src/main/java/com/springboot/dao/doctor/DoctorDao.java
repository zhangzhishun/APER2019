package com.springboot.dao.doctor;

import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;

import java.util.List;
import java.util.Map;

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


    /**
     * 根据用户名获取用户所有信息 以对象形式返回
     * @return Doctor
     */
    List<Map<String, Object>> getAllDoctor();

    /**
     * 根据用户名删除用户所有信息 以对象形式返回
     * @return Doctor
     */
    int doctorDelete(Integer DOCTOR_ID);
}
