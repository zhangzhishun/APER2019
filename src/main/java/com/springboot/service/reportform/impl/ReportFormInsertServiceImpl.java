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
    public boolean insertReportForm(String REPORTFORM_USERNAME, String REPORTFORM_TITLE, String REPORTFORM_CONTENT, String REPORTFORM_OFFICENAME, String REPORTFORM_IMG) {
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        ReportForm reportForm = new ReportForm();
        reportForm.setREPORTFORM_OFFICEID(officeGetServiceImpl.getOfficeIdByName(REPORTFORM_OFFICENAME));
        reportForm.setREPORTFORM_IMG(REPORTFORM_IMG);
        reportForm.setREPORTFORM_CONTENT(REPORTFORM_CONTENT);
        reportForm.setREPORTFORM_STATE("0");
        reportForm.setREPORTFORM_TIME(ft.format(new Date()));
        reportForm.setREPORTFORM_TITLE(REPORTFORM_TITLE);
        reportForm.setREPORTFORM_USERID(userGetServiceImpl.getIdByName(REPORTFORM_USERNAME));
        reportFormDao.insertReportForm(reportForm);
        return true;
    }
}
