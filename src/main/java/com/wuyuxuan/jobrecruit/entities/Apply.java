package com.wuyuxuan.jobrecruit.entities;

import java.util.Date;

public class Apply {
    private String applyGuid;
    private String userGuid;
    private String jobGuid;
    private Date applyDate;
    private Integer isDel;

    public String getApplyGuid() {
        return applyGuid;
    }

    public void setApplyGuid(String applyGuid) {
        this.applyGuid = applyGuid;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getJobGuid() {
        return jobGuid;
    }

    public void setJobGuid(String jobGuid) {
        this.jobGuid = jobGuid;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}
