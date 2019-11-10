package com.springboot.dao.reportform.impl;

import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class ReportFormDaoImpl implements ReportFormDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int insertReportForm(ReportForm reportForm) {
        String sql = "INSERT INTO report_form VALUES(?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,reportForm.getREPORTFORM_USERID(),reportForm.getREPORTFORM_TITLE(),reportForm.getREPORTFORM_CONTENT(),reportForm.getREPORTFORM_TIME()
        ,reportForm.getREPORTFORM_OFFICE(),reportForm.getREPORTFORM_STATE(),reportForm.getREPORTFORM_IMG());
    }
}
