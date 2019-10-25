package com.xd.pojo;

public class RegistrationInfo {
    private Integer id;

    private String rId;

    private String rTel;

    private Integer rDId;

    private Integer rCId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId == null ? null : rId.trim();
    }

    public String getrTel() {
        return rTel;
    }

    public void setrTel(String rTel) {
        this.rTel = rTel == null ? null : rTel.trim();
    }

    public Integer getrDId() {
        return rDId;
    }

    public void setrDId(Integer rDId) {
        this.rDId = rDId;
    }

    public Integer getrCId() {
        return rCId;
    }

    public void setrCId(Integer rCId) {
        this.rCId = rCId;
    }
}