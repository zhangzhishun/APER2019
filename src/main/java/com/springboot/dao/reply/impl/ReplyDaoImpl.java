package com.springboot.dao.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Repository
public class ReplyDaoImpl implements ReplyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME){
        String sql = "SELECT * FROM user,reply,report_form " +
                "WHERE reply.REPLY_REPOTFORMID = report_form.REPORTFORM_ID " +
                "AND report_form.REPORTFORM_USERID = user.USER_ID AND user.USER_NAME=?";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql,new Object[]{USER_NAME});
        for (Map<String,Object> re : reply) {
            System.out.println(re);
        }
        return reply;
    }

    @Override
    public List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID) {
        String sql = "SELECT * FROM user,reply,report_form " +
                "WHERE reply.REPLY_REPOTFORMID = report_form.REPORTFORM_ID " +
                "AND report_form.REPORTFORM_USERID = user.USER_ID AND reply.REPLY_ID=?";
        List<Map<String, Object>> reply = jdbcTemplate.queryForList(sql,new Object[]{REPLY_ID});
        for (Map<String,Object> re : reply) {
            System.out.println(re);
        }
        return reply;
    }
}
