package com.shu.db.service.impl;

import com.shu.db.dao.OpenDao;
import com.shu.db.dbaccess.DBAccess;
import com.shu.db.entity.Open;
import com.shu.db.service.OpenService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 21:01
 */
public class OpenServiceImpl implements OpenService {
    private static SqlSessionFactory sqlSessionFactory = null;
    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Open> getOpenList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        return openDao.getOpenList();
    }
    public void insertOpen(Open open) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        try{
            openDao.insertOpen(open);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public void deleteOpen(Open open) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        try{
            openDao.deleteOpen(open);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
    }

    public Open getOpenByKhAndGh(String kh,String gh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        List<Open> openList = openDao.getOpenList();
        for(Open open:openList){
            if(open.getKh().equals(kh)
                    && open.getGh().equals(gh)){
                return open;
            }
        }
        return null;
    }

    public Open getOpenByKhAndGhAndXq(String kh, String gh, String xq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        List<Open> openList = openDao.getOpenList();
        for(Open open:openList){
            if(open.getKh().equals(kh)
                    && open.getGh().equals(gh)
                    && open.getXq().equals(xq)){
                return open;
            }
        }
        return null;
    }

    public List<Open> getOpenListByKh(String kh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OpenDao openDao = sqlSession.getMapper(OpenDao.class);
        List<Open> openList = openDao.getOpenList();
        List<Open> res = new ArrayList<Open>();
        for(Open open:openList){
            if(open.getKh().equals(kh)){
                res.add(open);
            }
        }
        return res;
    }
}
