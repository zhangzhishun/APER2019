package com.springboot.service;

import com.springboot.domain.CSDN;

import java.util.List;
import java.util.Map;

/* 操作自己的数据库 */
public interface SelectAllBlogService {

    /*
     * 查找数据库表
     * @return List<Exam>
     */
    List<Map<String, Object>> FindIdTitleAYBlog();

    /*
     * 插入数据库表
     * @return List<Exam>
     */
    Integer InsertContent(CSDN csdn);


}
