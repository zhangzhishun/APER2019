package com.springboot.dao.office;

import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public interface OfficeDao {

    /**
     * 获取所有office科室内容
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getAllOffice();

}
