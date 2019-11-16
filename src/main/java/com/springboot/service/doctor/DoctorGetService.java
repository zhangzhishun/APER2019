package com.springboot.service.doctor;

import com.springboot.domain.Doctor;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface DoctorGetService {

    /**
     * 登录验证
     * @return List<Map<String,Object>>
     * */
    List<Map<String,Object>> getAllDoctor();

}
