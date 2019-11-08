package com.springboot.dao.impl;

import com.springboot.dao.csdnDao;
import com.springboot.domain.CSDN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public class csdnDaoImpl implements csdnDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int InsertContent(CSDN csdn){
        String sql = "INSERT INTO article VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,null,csdn.getArticle_user_id(),csdn.getArticle_title(),csdn.getArticle_content(),csdn.getArticle_view_count(),
                csdn.getArticle_comment_count(),csdn.getArticle_like_count(),csdn.getArticle_is_comment(),csdn.getArticle_status(),csdn.getArticle_order(),
                csdn.getArticle_update_time(),csdn.getArticle_create_time(),csdn.getArticle_summary());
    }


    @Override
    public List<Map<String, Object>> FindIdTitleAYBlog(){
        List<Map<String, Object>> result = jdbcTemplate.queryForList("select article_id,article_title FROM article");
        return result;
    }
}
