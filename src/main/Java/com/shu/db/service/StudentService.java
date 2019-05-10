package com.shu.db.service;

import com.shu.db.entity.Student;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 21:42
 */
public interface StudentService {
    List<Student> getStudentList();
    Student getStudentByXh(String xh);
    boolean Login(String xh, String pwd);
}
