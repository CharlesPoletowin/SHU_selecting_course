package com.shu.db.service.impl;

import com.shu.db.dao.DepartmentDao;
import com.shu.db.dbaccess.DBAccess;
import com.shu.db.entity.Department;
import com.shu.db.service.DepartmentService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 20:15
 */
public class DepartmentServiceImpl implements DepartmentService {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Department> getDepartmentList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentDao departmentDao= sqlSession.getMapper(DepartmentDao.class);
        return departmentDao.getDepartmentList();
    }

    public Department getDepartmentByYxh(String yxh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentDao departmentDao= sqlSession.getMapper(DepartmentDao.class);
        return departmentDao.getDepartmentByYxh(yxh);
    }
}
