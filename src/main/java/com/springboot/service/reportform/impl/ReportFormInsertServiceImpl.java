package com.springboot.service.reportform.impl;

import com.springboot.dao.reply.ReplyDao;
import com.springboot.dao.reportform.ReportFormDao;
import com.springboot.domain.ReportForm;
import com.springboot.service.office.OfficeGetService;
import com.springboot.service.reportform.ReportFormInsertService;
import com.springboot.service.user.UserGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author eternalSy
 * @version 1.0.0
 */
@Service
public class ReportFormInsertServiceImpl implements ReportFormInsertService {
    @Autowired
    ReportFormDao reportFormDao;

    @Autowired
    UserGetService userGetServiceImpl;

    @Autowired
    OfficeGetService officeGetServiceImpl;
    @Override
    public boolean insertReportForm(ReportForm reportForm) {
        reportFormDao.insertReportForm(reportForm);
        return true;
    }
}
