package com.shu.db.service;

import com.shu.db.entity.Open;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 20:59
 */
public interface OpenService {
    List<Open> getOpenList();
    void insertOpen(Open open);
    void deleteOpen(Open open);
    Open getOpenByKhAndGh(String kh,String gh);
    Open getOpenByKhAndGhAndXq(String kh, String gh, String xq);
    List<Open> getOpenListByKh(String kh);
}
