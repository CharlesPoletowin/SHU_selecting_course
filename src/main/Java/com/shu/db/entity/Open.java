package com.shu.db.entity;

/**
 * Created by PoleToWin on 2019/4/22 21:01
 */
public class Open {
    private String xq;
    private String kh;
    private String gh;
    private String sksj;

    public Open(String xq, String kh, String gh) {
        this.xq = xq;
        this.kh = kh;
        this.gh = gh;
    }

    public Open(String xq, String kh, String gh, String sksj) {
        this.xq = xq;
        this.kh = kh;
        this.gh = gh;
        this.sksj = sksj;
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

    public String getSksj() {
        return sksj;
    }

    public void setSksj(String sksj) {
        this.sksj = sksj;
    }
}
