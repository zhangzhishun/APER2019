package com.springboot.dao.user.impl;

import com.springboot.dao.user.UserDao;
import com.springboot.domain.User;
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
public class UserDaoImpl implements UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByName(String USER_NAME) {
        String sql = "SELECT * FROM user WHERE USER_NAME=?";
        User user = null;
        try{
            user = jdbcTemplate.queryForObject(sql, new Object[]{USER_NAME}, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int paramInt) throws SQLException {
                    User c = new User();
                    c.setUSER_PASSWORD(rs.getString("USER_PASSWORD"));
                    c.setUSER_PHONE(rs.getString("USER_PHONE"));
                    c.setUSER_SEX(rs.getString("USER_SEX"));
                    c.setUSER_REALNAME(rs.getString("USER_REALNAME"));
                    c.setUSER_WECHAT(rs.getString("USER_WECHAT"));
                    return c;
                }
            });
        }catch (EmptyResultDataAccessException empty){
            return user;
        }
        return user;

    }
}
