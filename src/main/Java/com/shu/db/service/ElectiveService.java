package com.shu.db.service;

import com.shu.db.entity.Elective;
import com.shu.db.entity.Open;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 18:23
 */
public interface ElectiveService {
    List<Elective> getElectiveListByXhAndXq(String xh, String xq);
    boolean insertElectiveWithXhAndOpen(String xh, Open open);
    boolean updateElectiveWithGhAndGrade(Elective elective,Integer pscj,Integer kscj);
    boolean deleteElective(Elective elective);
    List<Elective> getElectiveListByXh(String xh);
    List<Elective> getElectiveListByGh(String gh);

    boolean updateElectiveWithGhAndGrade(Elective elective,int pscj,int kscj,double perventage);
}
