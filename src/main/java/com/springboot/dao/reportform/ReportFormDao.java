package com.springboot.dao.reportform;

import com.springboot.domain.ReportForm;
import com.springboot.domain.User;

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
    int reportFormAdd(ReportForm reportForm);

    /**
     * 获取用户提交的所有信息 包括用户信息和提交信息
     * @return boolean*/
    List<Map<String,Object>> getReportForm();

    /**
     * 根据用户名获取用户所有回复 以对象形式返回
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getReportFormByReportFormID(Integer ReportForm_ID);

    /**
     * 用户注册
     * @return int
     */
    int reportFormUpdate(ReportForm reportForm);

    /**
     * 删除用户
     * @return int
     */
    int ReportFormDelete(Integer REPORTFORM_ID);
}
