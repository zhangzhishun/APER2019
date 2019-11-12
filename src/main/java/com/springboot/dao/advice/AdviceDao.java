package com.springboot.dao.advice;

import com.springboot.domain.Advice;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface AdviceDao {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    int insertAdvice(Advice advice);
}
