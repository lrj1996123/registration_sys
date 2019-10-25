package com.xd.pojo;

public class ConsultInfo {
    private Integer id;

    private String cTime;

    private Integer cDId;

    private Integer cNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime == null ? null : cTime.trim();
    }

    public Integer getcDId() {
        return cDId;
    }

    public void setcDId(Integer cDId) {
        this.cDId = cDId;
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }
}