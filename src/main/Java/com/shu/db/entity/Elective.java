package com.shu.db.entity;

/**
 * Created by PoleToWin on 2019/4/22 21:01
 */
public class Elective {
    private String xh;
    private String xq;
    private String kh;
    private String gh;
    private Integer pscj;
    private Integer kscj;
    private Integer zpcj;

    public Elective(String xh, String xq, String kh, String gh) {
        this.xh = xh;
        this.xq = xq;
        this.kh = kh;
        this.gh = gh;
    }

    public Elective(String xh, Open open) {
        this.xh = xh;
        this.xq = open.getXq();
        this.kh = open.getKh();
        this.gh = open.getGh();
        this.zpcj = null;
        this.pscj = null;
        this.kscj = null;
    }

    public Elective(String xh, String xq, String kh, String gh, Integer pscj, Integer kscj, Integer zpcj) {
        this.xh = xh;
        this.xq = xq;
        this.kh = kh;
        this.gh = gh;
        this.pscj = pscj;
        this.kscj = kscj;
        this.zpcj = zpcj;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public Integer getPscj() {
        return pscj;
    }

    public void setPscj(Integer pscj) {
        this.pscj = pscj;
    }

    public Integer getKscj() {
        return kscj;
    }

    public void setKscj(Integer kscj) {
        this.kscj = kscj;
    }

    public Integer getZpcj() {
        return zpcj;
    }

    public void setZpcj(Integer zpcj) {
        this.zpcj = zpcj;
    }
}

