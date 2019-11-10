package com.springboot.dao.reportform;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormDao {

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReplyByUSERNAME(String USER_NAME);

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReplyByREPLYID(String REPLY_ID);
}
