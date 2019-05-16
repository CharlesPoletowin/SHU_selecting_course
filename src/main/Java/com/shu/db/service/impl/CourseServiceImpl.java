package com.shu.db.service.impl;

import com.shu.db.dao.CourseDao;
import com.shu.db.dbaccess.DBAccess;
import com.shu.db.entity.Course;
import com.shu.db.service.CourseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 18:28
 */
public class CourseServiceImpl implements CourseService {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }

    public Course getCourseByKh(String kh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.getCourse(kh);
    }
    public List<Course> getCourseList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.getCourseList();
    }
    public List<Course> getCourseListbyYxh(String yxh){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CourseDao courseDao = sqlSession.getMapper(CourseDao.class);
        return courseDao.getCourseListbyYxh(yxh);
    }
}
