package com.springboot.service.reportform.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.service.reportform.ReportFormGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReportFormGetServiceImpl implements ReportFormGetService {
    @Autowired
    ReplyDao replyDaoImpl;

    @Override
    public List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME) {
        return replyDaoImpl.getReplyByUSERNAME(USER_NAME);
    }

    @Override
    public List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID) {
        List<Map<String, Object>> result=  replyDaoImpl.getReplyByREPLYID(REPLY_ID);
        return result;
    }
}
