package com.shu.db.dao;

import com.shu.db.entity.Teacher;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 17:58
 */
public interface TeacherDao {
    Teacher getTeacher(String gh);
    List<Teacher> getTeacherList();
    void insertTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(String gh);
}
