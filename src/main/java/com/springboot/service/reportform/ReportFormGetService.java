package com.springboot.service.reportform;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormGetService {

    /**
     * 获取用户所有回复
     * @return List<Map<String, Object>>*/
    List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME);

    /**
     * 获取用户指定一个回复
     * @return Reply*/
    List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID);
}
