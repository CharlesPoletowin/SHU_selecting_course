package com.shu.db.entity;

/**
 * Created by PoleToWin on 2019/4/22 21:01
 */
public class Student {
    private String xh;
    private String pwd;
    private String xm;
    private String xb;
    private String csrq;
    private String jg;
    private String sjhm;
    private String yxh;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Student(String xh, String pwd, String yxh) {
        this.xh = xh;
        this.pwd = pwd;
        this.yxh = yxh;
    }

    public Student(String xh, String pwd, String xm, String xb, String csrq, String jg, String sjhm, String yxh) {
        this.xh = xh;
        this.pwd = pwd;
        this.xm = xm;
        this.xb = xb;
        this.csrq = csrq;
        this.jg = jg;
        this.sjhm = sjhm;
        this.yxh = yxh;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
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

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }
}
