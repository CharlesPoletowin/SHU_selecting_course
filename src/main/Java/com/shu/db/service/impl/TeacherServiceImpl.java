package com.shu.db.service.impl;

import com.shu.db.dao.TeacherDao;
import com.shu.db.dbaccess.DBAccess;
import com.shu.db.entity.Teacher;
import com.shu.db.service.TeacherService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 21:58
 */
public class TeacherServiceImpl implements TeacherService {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Teacher> getTeacherList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacherList = teacherDao.getTeacherList();
        return teacherList;
    }

    public Teacher getTeacherByGh(String gh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        Teacher teacher = teacherDao.getTeacher(gh);
        return teacher;
    }

    public boolean Login(String gh, String pwd) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TeacherDao teacherDao = sqlSession.getMapper(TeacherDao.class);
        List<Teacher> teacherList = teacherDao.getTeacherList();
        for( Teacher teacher : teacherList){
            if(teacher.getGh().equals(gh)
                    && teacher.getPwd().equals(pwd)){
                return true;
            }
        }
        return false;
    }
}
