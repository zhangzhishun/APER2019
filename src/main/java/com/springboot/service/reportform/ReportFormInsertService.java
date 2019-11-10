package com.springboot.service.reportform;

import com.springboot.domain.ReportForm;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface ReportFormInsertService {

    /**
     * 向ReportForm插入数据
     * @return boolean*/
    boolean insertReportForm(String REPORTFORM_USERNAME,String REPORTFORM_TITLE,String REPORTFORM_CONTENT,String REPORTFORM_OFFICENAME,String REPORTFORM_IMG);

}
