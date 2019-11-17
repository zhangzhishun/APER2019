package com.springboot.service.reply.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.service.reply.ReplyDeleteService;
import com.springboot.service.reportform.ReportFormDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReplyDeleteServiceImpl implements ReplyDeleteService {
    @Autowired
    ReplyDao replyDao;

    @Override
    public int replyDelete(Integer REPLY_ID) {
        return replyDao.replyDelete(REPLY_ID);
    }
}
