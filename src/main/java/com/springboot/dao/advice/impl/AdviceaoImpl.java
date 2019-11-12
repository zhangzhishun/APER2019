package com.springboot.dao.advice.impl;

import com.springboot.dao.advice.AdviceDao;
import com.springboot.domain.Advice;
import com.springboot.domain.ReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class AdviceaoImpl implements AdviceDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int insertAdvice(Advice advice) {
        String sql = "INSERT INTO advice VALUES(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,advice.getADVICE_TITLE(),advice.getADVICE_CONTENT(),advice.getADVICE_TIME(),
                advice.getADVICE_REPLY(),advice.getADVICE_REPLY_TIME(),advice.getUSER_ID());
    }
}
