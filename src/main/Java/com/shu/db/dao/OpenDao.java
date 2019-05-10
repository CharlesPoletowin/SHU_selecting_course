package com.shu.db.dao;

import com.shu.db.entity.Open;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 17:56
 */
public interface OpenDao {
    List<Open> getOpenList();
    void insertOpen (Open open);
    void deleteOpen (Open open);
}
