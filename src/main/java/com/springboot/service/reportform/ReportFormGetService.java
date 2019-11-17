package com.springboot.service.reportform;

import com.springboot.domain.ReportForm;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormGetService {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    List<Map<String,Object>> getReportForm();

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    List<Map<String,Object>> getReportFormByREPORTFORM_ID(Integer REPORTFORM_ID);

}
