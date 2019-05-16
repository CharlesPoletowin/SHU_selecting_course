package com.shu.db.servlet;

import com.shu.db.entity.Course;
import com.shu.db.entity.Elective;
import com.shu.db.entity.Student;
import com.shu.db.service.impl.CourseServiceImpl;
import com.shu.db.service.impl.ElectiveServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PoleToWin on 2019/5/16 15:02
 */
@WebServlet("/Complete")
public class CompleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Student student =(Student) request.getSession().getAttribute("student");
        String xh=student.getXh();
        ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
        List<Elective> li= electiveService.getElectiveListByXh(xh);
        String s1="08305001";
        String s2="08305002";
        String s3="08305003";
        String s4="08305004";
        String s5="08305005";
        Map<String, String> result = new HashMap<String, String>();
        for (Elective ee:li){
            if(ee.getKh().equals(s1)&&ee.getZpcj()!=null){
                result.put(s1,ee.getZpcj().toString());
                continue;
            }
            else if(ee.getKh().equals(s1)){
                result.put(s1,null);
                continue;
            }
            if(ee.getKh().equals(s2)&&ee.getZpcj()!=null){
                result.put(s2,ee.getZpcj().toString());
                continue;
            }
            else if(ee.getKh().equals(s2)){
                result.put(s2,null);
                continue;
            }
            if(ee.getKh().equals(s3)&&ee.getZpcj()!=null){
                result.put(s3,ee.getZpcj().toString());
                continue;
            }
            else if(ee.getKh().equals(s3)){
                result.put(s3,null);
                continue;
            }
            if(ee.getKh().equals(s4)&&ee.getZpcj()!=null){
                result.put(s4,ee.getZpcj().toString());
                continue;
            }
            else if(ee.getKh().equals(s4)){
                result.put(s4,null);
                continue;
            }
            if(ee.getKh().equals(s5)&&ee.getZpcj()!=null){
                result.put(s5,ee.getZpcj().toString());
                continue;
            }
            else if(ee.getKh().equals(s5)){
                result.put(s5,null);
                continue;
            }
        }
        CourseServiceImpl CourseService=new CourseServiceImpl();
        List<Course> course=CourseService.getCourseListbyYxh(student.getYxh());
        request.getSession().setAttribute("CourseList",course);
        request.getSession().setAttribute("result",result);
        response.sendRedirect("/complete.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
