package com.shu.db.dao;

import com.shu.db.entity.Student;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 17:57
 */
public interface StudentDao {
    Student getStudent(String xh);
    void insertStudent(Student student);
    void deleteStudent(String xh);
    void updateStudent(Student student);
    List<Student> getStudentList();
}
