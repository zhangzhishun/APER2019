package com.springboot.dao.doctor.impl;

import com.springboot.dao.doctor.DoctorDao;
import com.springboot.domain.Admin;
import com.springboot.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class DoctorDaoImpl implements DoctorDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Doctor getDoctorByName(String DOCTOR_NAME) {
        String sql = "SELECT * FROM doctor WHERE DOCTOR_NAME=?";
        Doctor doctor = null;
        try{
            doctor = jdbcTemplate.queryForObject(sql, new Object[]{DOCTOR_NAME}, new RowMapper<Doctor>() {
                @Override
                public Doctor mapRow(ResultSet rs, int paramInt) throws SQLException {
                    Doctor c = new Doctor();
                    c.setDOCTOR_PASSWORD(rs.getString("DOCTOR_PASSWORD"));
                    c.setDOCTOR_REALNAME(rs.getString("DOCTOR_REALNAME"));
                    c.setDOCTOR_SEX(rs.getString("DOCTOR_SEX"));
                    c.setDOCTOR_PHONE(rs.getString("DOCTOR_PHONE"));
                    c.setDOCTOR_WECHAT(rs.getString("DOCTOR_WECHAT"));
                    c.setDOCTOR_OFFICEID(rs.getInt("DOCTOR_OFFICEID"));
                    return c;
                }
            });
        }catch (EmptyResultDataAccessException empty){
            return doctor;
        }
        return doctor;

    }
}
