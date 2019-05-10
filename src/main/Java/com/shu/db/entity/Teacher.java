package com.shu.db.entity;

/**
 * Created by PoleToWin on 2019/4/22 21:01
 */
public class Teacher {
    private String gh;
    private String pwd;
    private String xm;
    private String xb;
    private String csrq;
    private String xl;
    private String jbgz;
    private String yxh;

    public Teacher(String gh, String pwd, String yxh) {
        this.gh = gh;
        this.pwd = pwd;
        this.yxh = yxh;
    }

    public Teacher(String gh, String pwd, String xm, String xb, String csrq, String xl, String jbgz, String yxh) {
        this.gh = gh;
        this.pwd = pwd;
        this.xm = xm;
        this.xb = xb;
        this.csrq = csrq;
        this.xl = xl;
        this.jbgz = jbgz;
        this.yxh = yxh;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getJbgz() {
        return jbgz;
    }

    public void setJbgz(String jbgz) {
        this.jbgz = jbgz;
    }

    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }
}
