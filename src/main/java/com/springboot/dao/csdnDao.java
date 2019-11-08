package com.springboot.dao;

import com.springboot.domain.CSDN;

import java.util.List;
import java.util.Map;


public interface csdnDao{
    /*
     * 插入新数据
     * @return int
     */

    int InsertContent(CSDN csdn);

    /*
     * 更新数据库表
     * @return List<Exam>
     */
    List<Map<String, Object>> FindIdTitleAYBlog();

}
