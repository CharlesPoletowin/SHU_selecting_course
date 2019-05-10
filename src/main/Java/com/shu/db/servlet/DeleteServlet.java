package com.shu.db.servlet;

import com.shu.db.entity.Elective;
import com.shu.db.entity.Student;
import com.shu.db.service.impl.ElectiveServiceImpl;
import com.shu.db.tool.StudentLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by PoleToWin on 2019/5/3 19:57
 */
@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String kh = request.getParameter("kh");
        String gh = request.getParameter("gh");
        Student student =(Student) request.getSession().getAttribute("student");
        Elective elective=new Elective(student.getXh(),"2018-2019春季",kh,gh);
        if (elective!=null){
            ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
            boolean success = electiveService.deleteElective(elective);
            if(success){
                request.getSession().setAttribute("stat","退课成功");
            }else{
                request.getSession().setAttribute("stat","退课失败");
            }
        }
        else{
            request.getSession().setAttribute("stat","退课失败，未选该课");
        }
        StudentLogin.CourseTableFunction(request,student.getXh());
        response.sendRedirect("/student.jsp");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
