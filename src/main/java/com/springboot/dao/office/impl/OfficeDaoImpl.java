package com.springboot.dao.office.impl;

import com.springboot.dao.office.OfficeDao;
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
public class OfficeDaoImpl implements OfficeDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllOffice() {
        String sql = "SELECT * FROM office";
        List<Map<String, Object>> office = jdbcTemplate.queryForList(sql);
        for (Map<String,Object> re : office) {
            System.out.println(re);
        }
        return office;
    }
}
