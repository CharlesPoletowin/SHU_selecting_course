package com.shu.db.servlet;

import com.shu.db.entity.*;
import com.shu.db.service.impl.*;
import com.shu.db.tool.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PoleToWin on 2019/4/22 21:03
 */

@WebServlet("/Login")
public class LoginUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StudentServiceImpl studentService = new StudentServiceImpl();
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        OpenServiceImpl openService = new OpenServiceImpl();
        ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
        DepartmentServiceImpl departmentService = new DepartmentServiceImpl();

        if(username.equals("admin")
                && password.equals("admin")){
            Admin admin = new Admin("管理员");
            request.getSession().setAttribute("admin",admin);
            List<Student> studentList = studentService.getStudentList();
            request.getSession().setAttribute("studentList",studentList);
            List<Teacher> teacherList = teacherService.getTeacherList();
            request.getSession().setAttribute("teacherList",teacherList);
            List<Department> departmentList = departmentService.getDepartmentList();
            request.getSession().setAttribute("departmentList",departmentList);
            System.out.println(studentList);
            response.sendRedirect("/admin.jsp");
        }
        else if(studentService.Login(username,password)){
            Student student = studentService.getStudentByXh(username);
            List<Elective> electiveList = electiveService.getElectiveListByXh(username);
            System.out.println(electiveList);
            List<MapElective> mapElectiveList = new ArrayList<MapElective>();
            char ch = 'A';
            for( Elective elective : electiveList){
                if( elective.getXq().equals("2018-2019春季")){
                    MapElective mapElective = new MapElective(ch,elective);
                    int chnum = (int)ch;
                    chnum = chnum+1;
                    ch = (char)chnum;
                    mapElectiveList.add(mapElective);
                }
            }
            List<Open> openList = openService.getOpenList();
            ClassHelper classHelper =new ClassHelper();
            ArrayList<MapDayTime> mapDayTimeList = new ArrayList<MapDayTime>();
            for( MapElective mapElective : mapElectiveList){
                MapDayTime mapDayTime = new MapDayTime();
                String cTime = "";
                for(Open open : openList){
                    if(mapElective.getElective().getGh().equals(open.getGh())
                            && mapElective.getElective().getGh().equals(open.getGh())){
                        cTime = open.getSksj();break;
                    }
                }
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(cTime);
                ClassTime classTime = classHelper.getClassTimeByString(arrayList);
                ArrayList<DayTime> dayTimeArrayList = classTime.getPeriod();
                mapDayTime.setMapper(mapElective.getMapper());
                mapDayTime.setDayTimeArrayList(dayTimeArrayList);
                mapDayTimeList.add(mapDayTime);
            }
            char[][] chars = new char [13][5];
            for(int i = 0; i<13;i++){
                for(int  j =0 ;j<5;j++){
                    chars[i][j] = ' ';
                }
            }
            for(MapDayTime mapDayTime :mapDayTimeList){
                for(DayTime dayTime: mapDayTime.getDayTimeArrayList()){
                    int d = dayTime.getDay()-1;
                    int s = dayTime.getStart()-1;
                    int e = dayTime.getEnd() -1;
                    for(int  i = s; i<=e;i++){

                        chars[i][d] = mapDayTime.getMapper();
                    }
                }
            }
            ArrayList<CourseTableRow> courseTableRowArrayList = new ArrayList<CourseTableRow>();

            for(int i = 0;i<13;i++){
                char[] subchars = new char[5];
                for(int j = 0;j<5;j++){
                    subchars[j] = chars[i][j];
                }
                CourseTableRow courseTableRow = new CourseTableRow(subchars,i+1);
                courseTableRowArrayList.add(courseTableRow);
            }

            request.getSession().setAttribute("CourseTable",courseTableRowArrayList);
            request.getSession().setAttribute("historyList",electiveList);
            request.getSession().setAttribute("MapElectiveList",mapElectiveList);
            request.getSession().setAttribute("student",student);
            response.sendRedirect("/student.jsp");
        }
        else if(teacherService.Login(username,password)){
            Teacher teacher = teacherService.getTeacherByGh(username);
            List<Elective> electiveList = electiveService.getElectiveListByGh(teacher.getGh());

            request.getSession().setAttribute("teacher",teacher);
            request.getSession().setAttribute("electiveList",electiveList);
            response.sendRedirect("/teacher.jsp");
        }else{
            String alert = "登录失败";
            request.setAttribute("alert",alert);
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
