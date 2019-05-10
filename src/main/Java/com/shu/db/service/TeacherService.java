package com.shu.db.service;

import com.shu.db.entity.Teacher;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 21:55
 */
public interface TeacherService  {
    List<Teacher> getTeacherList();
    Teacher getTeacherByGh(String gh);
    boolean Login(String gh,String pwd);
}
