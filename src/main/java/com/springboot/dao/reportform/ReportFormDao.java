package com.springboot.dao.reportform;

import com.springboot.domain.ReportForm;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormDao {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    int insertReportForm(ReportForm reportForm);
}
