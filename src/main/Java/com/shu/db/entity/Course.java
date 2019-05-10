package com.shu.db.entity;

/**
 * Created by PoleToWin on 2019/4/22 21:00
 */
public class Course {
    private String kh;
    private String km;
    private Integer xf;
    private Integer xs;
    private String yxh;

    public Course(String kh, String yxh) {
        this.kh = kh;
        this.yxh = yxh;
    }

    public Course(String kh, String km, Integer xf, Integer xs, String yxh) {
        this.kh = kh;
        this.km = km;
        this.xf = xf;
        this.xs = xs;
        this.yxh = yxh;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public Integer getXf() {
        return xf;
    }

    public void setXf(Integer xf) {
        this.xf = xf;
    }

    public Integer getXs() {
        return xs;
    }

    public void setXs(Integer xs) {
        this.xs = xs;
    }

    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }
}
