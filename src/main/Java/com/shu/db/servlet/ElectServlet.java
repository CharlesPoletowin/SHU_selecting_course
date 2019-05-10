package com.shu.db.servlet;

import com.shu.db.entity.Elective;
import com.shu.db.entity.Open;
import com.shu.db.entity.Student;
import com.shu.db.service.impl.ElectiveServiceImpl;
import com.shu.db.service.impl.OpenServiceImpl;
import com.shu.db.tool.StudentLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PoleToWin on 2019/5/2 21:02
 */
@WebServlet("/Elect")
public class ElectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String kh = request.getParameter("kh");
        String gh = request.getParameter("gh");
        Student student =(Student) request.getSession().getAttribute("student");

        OpenServiceImpl openService = new OpenServiceImpl();
        Open open = openService.getOpenByKhAndGhAndXq(kh,gh,"2018-2019春季");
//        System.out.println("ElectServlet Open exist?"+open);
        if(open !=null){
            ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
            long startTime = System.currentTimeMillis();
            boolean success1 = true;
            for (Elective item : electiveService.getElectiveListByXh(student.getXh())){
                if (item.getKh().equals(open.getKh())){
                    success1=false;
                }
            }
//            System.out.println("ElectServlet success1:"+success1);
            if(success1){
                boolean success = electiveService.insertElectiveWithXhAndOpen(student.getXh(),open);
                System.out.println("In ElectServlet "+student.getXh()+open.getXq()+open.getKh());
                long endTime = System.currentTimeMillis();
                System.out.println("In ElectServlet InsertTime Cost " + (endTime-startTime) +"ms" );
                if(success){
                    request.getSession().setAttribute("stat","选课成功");
                }else{
                    request.getSession().setAttribute("stat","选课失败");
                }
            }
            else{
                request.getSession().setAttribute("stat","选课失败");
            }
        }else{
            request.getSession().setAttribute("stat","选课失败");
        }
        long s = System.currentTimeMillis();
        StudentLogin.CourseTableFunction(request,student.getXh());
        long e = System.currentTimeMillis();
        System.out.println(" CourseTable Cost " + (e-s) +"ms");
        response.sendRedirect("/student.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
