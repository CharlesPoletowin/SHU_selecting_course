package com.shu.db.dao;

import com.shu.db.entity.Elective;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 17:55
 */
public interface ElectiveDao {
    List<Elective> getElectiveList();
    void insertElective( Elective elective);
    void deleteElective( Elective elective);
    void updateElective( Elective elective);
}
