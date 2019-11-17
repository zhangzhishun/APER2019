package com.springboot.service.reply;

import com.springboot.domain.Reply;
import com.springboot.domain.ReportForm;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReplyUpdateService {

    /**
     * 向ReportForm插入数据
     * @return int
     **/
    int updateReply(Reply reply);

}
