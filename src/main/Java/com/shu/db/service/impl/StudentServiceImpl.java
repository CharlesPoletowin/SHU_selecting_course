package com.shu.db.service.impl;

import com.shu.db.dao.StudentDao;
import com.shu.db.dbaccess.DBAccess;
import com.shu.db.entity.Student;
import com.shu.db.service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 21:53
 */
public class StudentServiceImpl implements StudentService {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }


    public List<Student> getStudentList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        return studentDao.getStudentList();
    }

    public Student getStudentByXh(String xh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.getStudent(xh);
        return student;
    }

    public boolean Login(String xh, String pwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentDao studentDao = sqlSession.getMapper(StudentDao.class);
        Student student = studentDao.getStudent(xh);
        if(student == null){
            return false;
        }
        if(student.getPwd().equals(pwd)){
            return true;
        }
        return false;
    }
}
