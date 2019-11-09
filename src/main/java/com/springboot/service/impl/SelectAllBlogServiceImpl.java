package com.springboot.service.impl;

import com.springboot.dao.csdnDao;
import com.springboot.domain.CSDN;
import com.springboot.service.SelectAllBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SelectAllBlogServiceImpl implements SelectAllBlogService {

    @Autowired
    csdnDao csdnDaoImpl;

    @Override
    public List<Map<String, Object>> FindIdTitleAYBlog() {
        return csdnDaoImpl.FindIdTitleAYBlog();
    }

    @Override
    public Integer InsertContent(CSDN csdn) {
        return csdnDaoImpl.InsertContent(csdn);
    }
}
