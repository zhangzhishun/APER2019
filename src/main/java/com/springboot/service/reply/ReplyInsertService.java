package com.springboot.service.reply;

import com.springboot.domain.Reply;
import com.springboot.domain.ReportForm;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReplyInsertService {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    int insertReportForm(Reply reply);

}
