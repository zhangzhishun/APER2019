package com.springboot.service.impl;
import com.springboot.dao.copyCsdnDao;
import com.springboot.domain.CSDN;
import com.springboot.service.CopyFromCsdnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CopyFromCsdnServiceImpl implements CopyFromCsdnService {
    @Autowired
    copyCsdnDao copyCsdnDaoImpl;

    @Override
    public List<CSDN> getCsdnResult() {
        return copyCsdnDaoImpl.getCsdnResult();
    }

    @Override
    public List<CSDN> FindAllArticle(String pages) {
        return copyCsdnDaoImpl.FindAllArticle(pages);
    }

    @Override
    public Map<String, String> getContentFromUrl(String url) {
        return copyCsdnDaoImpl.getContentFromUrl(url);
    }

    @Override
    public CSDN FindByTitle(String title) {
        return copyCsdnDaoImpl.FindByTitle(title);
    }

    @Override
    public void setAcw_sc__v2(String acw_sc__v2) {
        copyCsdnDaoImpl.setAcw_sc__v2(acw_sc__v2);
    }

    @Override
    public String getAcw_sc__v2() {
        return copyCsdnDaoImpl.getAcw_sc__v2();
    }

}
