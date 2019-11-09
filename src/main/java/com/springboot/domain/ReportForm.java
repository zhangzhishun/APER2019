package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class ReportForm {
    private Integer REPORTFORM_ID;
    private Integer REPORTFORM_USER;
    private String REPORTFORM_TITLE;
    private String REPORTFORM_CONTENT;
    private String REPORTFORM_TIME;
    private Integer REPORTFORM_OFFICE;
    private String REPORTFORM_STATE;
    private String REPORTFORM_IMG;

    public ReportForm() {
    }

    public Integer getREPORTFORM_ID() {
        return REPORTFORM_ID;
    }

    public void setREPORTFORM_ID(Integer REPORTFORM_ID) {
        this.REPORTFORM_ID = REPORTFORM_ID;
    }

    public Integer getREPORTFORM_USER() {
        return REPORTFORM_USER;
    }

    public void setREPORTFORM_USER(Integer REPORTFORM_USER) {
        this.REPORTFORM_USER = REPORTFORM_USER;
    }

    public String getREPORTFORM_TITLE() {
        return REPORTFORM_TITLE;
    }

    public void setREPORTFORM_TITLE(String REPORTFORM_TITLE) {
        this.REPORTFORM_TITLE = REPORTFORM_TITLE;
    }

    public String getREPORTFORM_CONTENT() {
        return REPORTFORM_CONTENT;
    }

    public void setREPORTFORM_CONTENT(String REPORTFORM_CONTENT) {
        this.REPORTFORM_CONTENT = REPORTFORM_CONTENT;
    }

    public String getREPORTFORM_TIME() {
        return REPORTFORM_TIME;
    }

    public void setREPORTFORM_TIME(String REPORTFORM_TIME) {
        this.REPORTFORM_TIME = REPORTFORM_TIME;
    }

    public Integer getREPORTFORM_OFFICE() {
        return REPORTFORM_OFFICE;
    }

    public void setREPORTFORM_OFFICE(Integer REPORTFORM_OFFICE) {
        this.REPORTFORM_OFFICE = REPORTFORM_OFFICE;
    }

    public String getREPORTFORM_STATE() {
        return REPORTFORM_STATE;
    }

    public void setREPORTFORM_STATE(String REPORTFORM_STATE) {
        this.REPORTFORM_STATE = REPORTFORM_STATE;
    }

    public String getREPORTFORM_IMG() {
        return REPORTFORM_IMG;
    }

    public void setREPORTFORM_IMG(String REPORTFORM_IMG) {
        this.REPORTFORM_IMG = REPORTFORM_IMG;
    }

    @Override
    public String toString() {
        return "ReportForm{" +
                "REPORTFORM_ID=" + REPORTFORM_ID +
                ", REPORTFORM_USER=" + REPORTFORM_USER +
                ", REPORTFORM_TITLE='" + REPORTFORM_TITLE + '\'' +
                ", REPORTFORM_CONTENT='" + REPORTFORM_CONTENT + '\'' +
                ", REPORTFORM_TIME='" + REPORTFORM_TIME + '\'' +
                ", REPORTFORM_OFFICE=" + REPORTFORM_OFFICE +
                ", REPORTFORM_STATE='" + REPORTFORM_STATE + '\'' +
                ", REPORTFORM_IMG='" + REPORTFORM_IMG + '\'' +
                '}';
    }
}