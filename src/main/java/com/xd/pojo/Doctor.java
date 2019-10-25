package com.xd.pojo;

public class Doctor {
    private Integer id;

    private String dName;

    private String dGroup;

    private String dMajor;

    private String dGender;

    private String dTel;

    private String dUser;

    private String dPass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName == null ? null : dName.trim();
    }

    public String getdGroup() {
        return dGroup;
    }

    public void setdGroup(String dGroup) {
        this.dGroup = dGroup == null ? null : dGroup.trim();
    }

    public String getdMajor() {
        return dMajor;
    }

    public void setdMajor(String dMajor) {
        this.dMajor = dMajor == null ? null : dMajor.trim();
    }

    public String getdGender() {
        return dGender;
    }

    public void setdGender(String dGender) {
        this.dGender = dGender == null ? null : dGender.trim();
    }

    public String getdTel() {
        return dTel;
    }

    public void setdTel(String dTel) {
        this.dTel = dTel == null ? null : dTel.trim();
    }

    public String getdUser() {
        return dUser;
    }

    public void setdUser(String dUser) {
        this.dUser = dUser == null ? null : dUser.trim();
    }

    public String getdPass() {
        return dPass;
    }

    public void setdPass(String dPass) {
        this.dPass = dPass == null ? null : dPass.trim();
    }
}