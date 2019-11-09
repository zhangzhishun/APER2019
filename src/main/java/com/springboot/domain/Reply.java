package com.springboot.domain;

/**
 * @author eternalSy
 * @version 1.0.0
 */
public class Reply {
    private Integer REPLY_ID;
    private Integer REPLY_REPOTFORMID;
    private String REPLY_DOCTOR;
    private String REPLY_CONTENT;
    private String REPLY_TIME;
    private String REPLY_IMG;

    public Reply() {
    }

    public Integer getREPLY_ID() {
        return REPLY_ID;
    }

    public void setREPLY_ID(Integer REPLY_ID) {
        this.REPLY_ID = REPLY_ID;
    }

    public Integer getREPLY_REPOTFORMID() {
        return REPLY_REPOTFORMID;
    }

    public void setREPLY_REPOTFORMID(Integer REPLY_REPOTFORMID) {
        this.REPLY_REPOTFORMID = REPLY_REPOTFORMID;
    }

    public String getREPLY_DOCTOR() {
        return REPLY_DOCTOR;
    }

    public void setREPLY_DOCTOR(String REPLY_DOCTOR) {
        this.REPLY_DOCTOR = REPLY_DOCTOR;
    }

    public String getREPLY_CONTENT() {
        return REPLY_CONTENT;
    }

    public void setREPLY_CONTENT(String REPLY_CONTENT) {
        this.REPLY_CONTENT = REPLY_CONTENT;
    }

    public String getREPLY_TIME() {
        return REPLY_TIME;
    }

    public void setREPLY_TIME(String REPLY_TIME) {
        this.REPLY_TIME = REPLY_TIME;
    }

    public String getREPLY_IMG() {
        return REPLY_IMG;
    }

    public void setREPLY_IMG(String REPLY_IMG) {
        this.REPLY_IMG = REPLY_IMG;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "REPLY_ID=" + REPLY_ID +
                ", REPLY_REPOTFORMID=" + REPLY_REPOTFORMID +
                ", REPLY_DOCTOR='" + REPLY_DOCTOR + '\'' +
                ", REPLY_CONTENT='" + REPLY_CONTENT + '\'' +
                ", REPLY_TIME='" + REPLY_TIME + '\'' +
                ", REPLY_IMG='" + REPLY_IMG + '\'' +
                '}';
    }
}
