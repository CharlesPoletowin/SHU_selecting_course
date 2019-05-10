package com.shu.db.servlet;

import com.shu.db.entity.Course;
import com.shu.db.entity.CourseAndOpenAndTeacher;
import com.shu.db.entity.Open;
import com.shu.db.entity.Teacher;
import com.shu.db.service.impl.CourseServiceImpl;
import com.shu.db.service.impl.OpenServiceImpl;
import com.shu.db.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/2 13:33
 */
@WebServlet("/course")
public class courseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        CourseServiceImpl courseService = new CourseServiceImpl();
        OpenServiceImpl openService = new OpenServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        List<CourseAndOpenAndTeacher> ResList = new ArrayList<CourseAndOpenAndTeacher>();
        List<Open> openList = null;
        List<Teacher> teacherList = null;
        List<Course> courseList = null;

        long startMill = System.currentTimeMillis();
        HttpSession session =request.getSession();

        if((openList = (List<Open>)session.getAttribute("openList"))== null){
            openList = openService.getOpenList();
            session.setAttribute("openList",openList);
        }

        if( (teacherList = (List<Teacher>)session.getAttribute("teacherList"))==null){
            teacherList = teacherService.getTeacherList();
            session.setAttribute("teacherList",teacherList);
        }
        if((courseList = (List<Course>) session.getAttribute("courseList"))==null){
            courseList = courseService.getCourseList();
            session.setAttribute("courseList",courseList);
        }
        for(Open open :openList){
            Course c = null;
            for(Course course : courseList){
                if( course.getKh().equals(open.getKh())){
                    c = course;
                    break;
                }
            }
            Teacher t = null;
            for(Teacher teacher : teacherList){
                if( teacher.getGh().equals(open.getGh())){
                    t = teacher;
                    break;
                }
            }
            CourseAndOpenAndTeacher courseAndOpenAndTeacher = new CourseAndOpenAndTeacher(c, open,t);
            if(courseAndOpenAndTeacher.getOpen().getXq().equals("2018-2019春季")){
                ResList.add(courseAndOpenAndTeacher);
                System.out.println(courseAndOpenAndTeacher.getCourse().getKm());
            }

        }
        long endMill = System.currentTimeMillis();
        System.out.println(endMill - startMill + "ms");
        System.out.println("Reslist"+ResList);
        session.setAttribute("ResList",ResList);
    }
}
