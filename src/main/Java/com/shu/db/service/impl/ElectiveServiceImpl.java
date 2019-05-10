package com.shu.db.service.impl;

import com.shu.db.dao.ElectiveDao;
import com.shu.db.dbaccess.DBAccess;
import com.shu.db.entity.Elective;
import com.shu.db.entity.Open;
import com.shu.db.service.ElectiveService;
import com.shu.db.tool.ClassHelper;
import com.shu.db.tool.ClassTime;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 20:17
 */
public class ElectiveServiceImpl implements ElectiveService {
    private static SqlSessionFactory sqlSessionFactory = null;

    static {
        sqlSessionFactory = DBAccess.getSqlSessionFactory();
    }
    public List<Elective> getElectiveListByXhAndXq(String xh, String xq) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Elective> result = new ArrayList<Elective>();
        for(Elective elective : electiveList){
            if(elective.getXq().equals(xq)&& elective.getXh().equals(xh)){
                result.add(elective);
            }
        }
        return result;
    }

    public boolean insertElectiveWithXhAndOpen(String xh, Open open) {
        System.out.println("sid = " + xh);
        System.out.println("open = " + open.getXq()+","+open.getKh()+","+open.getGh()+","+open.getSksj());
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        OpenServiceImpl openService = new OpenServiceImpl();

        List<Elective> electiveListTotal = electiveDao.getElectiveList();
        ArrayList<Elective> electiveList = new ArrayList<Elective>();
        for( Elective elective : electiveListTotal){
            if(elective.getXq().equals(open.getXq())
                    && elective.getXh().equals(xh))
                electiveList.add(elective);
        }

        List<Open> openList = openService.getOpenList();
        ClassHelper classHelper = new ClassHelper();
        boolean Exist = false;
        for(Open open1 :openList){
            if(open.getGh().equals(open1.getGh())
                    && open.getGh().equals(open1.getGh())
                    && open.getXq().equals(open1.getXq())){
                Exist = true;
                break;
            }
        }
        if(!Exist){
            return false;
        }
        System.out.println(" Exist ");
        boolean ChooseYet = false;
        for(Elective elective:electiveList){
            if(elective.getXh().equals(xh)
                    && elective.getXq().equals(open.getXq())
                    && elective.getKh().equals(open.getKh())
                    && elective.getGh().equals(open.getGh())){
                ChooseYet = true;
                break;
            }
        }
        if( ChooseYet == true){
            return false;
        }
        System.out.println(" Havent Choose ");

        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<ClassTime> classTimeArrayList = new ArrayList<ClassTime>();


        for(Elective elective : electiveList){
            if(elective.getXh().equals(xh)){
                Open o = null;
                for(Open o1 : openList){
                    if(o1.getKh().equals(elective.getKh())
                            && o1.getGh().equals(elective.getGh())
                            && o1.getXq().equals(elective.getXq())){
                        o = o1;
                        break;
                    }
                }
                String ctime = o.getSksj();
                ArrayList<String> s = new ArrayList<String>();
                s.add(ctime);
                ClassTime classTime  = classHelper.getClassTimeByString(s);
                classTimeArrayList.add(classTime);
            }
        }
        ArrayList<String> sOpen = new ArrayList<String>();
        sOpen.add(open.getSksj());
        ClassTime classTime = classHelper.getClassTimeByString(sOpen);
        boolean isConflict = classHelper.IsConflict(classTimeArrayList,classTime);
        if(isConflict){
            return false;
        }

        System.out.println(" not Conlict ");

        try{
            Elective elective = new Elective(xh,open);
            electiveDao.insertElective(elective);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return  true;
    }

    public boolean updateElectiveWithGhAndGrade(Elective elective, Integer pscj, Integer kscj) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        elective.setPscj(pscj);
        elective.setKscj(kscj);
        List<Elective> electiveList = electiveDao.getElectiveList();
        boolean Found = false;
        for(Elective e: electiveList){
            if(e.getXh().equals(elective.getXh())
                    && e.getGh().equals(elective.getGh())
                    && e.getXq().equals(elective.getXq())
                    && e.getKh().equals(elective.getKh())){
                Found = true;
            }
        }
        if(!Found){
            return false;
        }

        try{
            electiveDao.updateElective(elective);
            sqlSession.commit();
            // 获取记录 判断是否相等

        }finally {
            sqlSession.close();
        }
        return true;
    }

    public boolean deleteElective(Elective elective) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        boolean ChooseYes = false;
        for(Elective e : electiveList){
            if(e.getXh().equals(elective.getXh())
                    && e.getKh().equals(elective.getKh())
                    && e.getXq().equals(elective.getXq())
                    && e.getGh().equals(elective.getGh())){
                ChooseYes = true;
            }
        }
        if(!ChooseYes){
            return false;
        }
        try{
            electiveDao.deleteElective(elective);
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }
        return true;
    }

    public List<Elective> getElectiveListByXh(String xh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Elective> result = new ArrayList<Elective>();
        for(Elective elective : electiveList){
            if(elective.getXh().equals(xh)){
                result.add(elective);
            }
        }
        return result;
    }

    public List<Elective> getElectiveListByGh(String gh) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        List<Elective> electiveList = electiveDao.getElectiveList();
        List<Elective> result = new ArrayList<Elective>();
        for(Elective elective : electiveList){
            if(elective.getGh().equals(gh)){
                result.add(elective);
            }
        }
        return result;
    }

    public boolean updateElectiveWithGhAndGrade(Elective elective, int pscj, int kscj, double perventage) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ElectiveDao electiveDao = sqlSession.getMapper(ElectiveDao.class);
        elective.setPscj(pscj);
        elective.setKscj(kscj);
        int zpcj = (int)(pscj*perventage + kscj*(1-perventage));
        elective.setZpcj(zpcj);
        List<Elective> electiveList = electiveDao.getElectiveList();
        boolean Found = false;
        for(Elective e: electiveList){
            if(e.getXh().equals(elective.getXh())
                    && e.getGh().equals(elective.getGh())
                    && e.getXq().equals(elective.getXq())
                    && e.getKh().equals(elective.getKh())){
                Found = true;
            }
        }
        if(!Found){
            return false;
        }

        try{
            electiveDao.updateElective(elective);
            sqlSession.commit();
            // 获取记录 判断是否相等

        }finally {
            sqlSession.close();
        }
        return true;
    }

}
