package com.shu.db.servlet;

import com.shu.db.entity.Elective;
import com.shu.db.entity.Open;
import com.shu.db.entity.Teacher;
import com.shu.db.service.impl.ElectiveServiceImpl;
import com.shu.db.service.impl.OpenServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/13 21:03
 */
@WebServlet("/UpdateScores")
public class UpdateScoresServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("Utf-8");
        response.setContentType("text/html;charset=UTF-8");
        Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
        String gh = teacher.getGh();
        Integer count = Integer.parseInt(request.getParameter("count"));
        ElectiveServiceImpl electiveService = new ElectiveServiceImpl();
        if (count!=null){
            for (int i=0;i<count;i++){
                String kh = request.getParameter(i+"kh");
                String xh = request.getParameter(i+"xh");
                String p1 = request.getParameter(i+"pscj");
                String p2 = request.getParameter(i+"kscj");
                String PercentageOfPscj = request.getParameter("Percentage");
                if( p1 == null || p2 == null || p1.equals("") || p2.equals("")|| PercentageOfPscj == null || PercentageOfPscj.equals("")){
                    request.getSession().setAttribute("updateStat","改分失败");
                }
                else{
                    boolean b1 =true;
                    boolean b2 = true;
                    boolean b3 = true;
                    for(int j = 0;j<p1.length();j++){
                        char ch = p1.charAt(j);
                        if(ch>'9'||ch<'0'){
                            request.getSession().setAttribute("updateStat","改分失败");
                            b1 = false;
                            break;
                        }
                    }
                    for(int j = 0;j<p2.length();j++){
                        char ch = p2.charAt(j);
                        if(ch>'9'||ch<'0'){
                            request.getSession().setAttribute("updateStat","改分失败");
                            b2 = false;
                            break;
                        }
                    }
                    for(int j = 0; j<PercentageOfPscj.length();j++){
                        char ch  = PercentageOfPscj.charAt(j);
                        if(j == 0 && ch !='0'){
                            request.getSession().setAttribute("updateStat","改分失败");
                            b3 = false;
                            break;
                        }
                        else if( j == 1 && ch!='.'){
                            request.getSession().setAttribute("updateStat","改分失败");
                            b3 = false;
                            break;
                        }
                        else if( (ch >'9' ||ch <'0')&& j >= 2){
                            request.getSession().setAttribute("updateStat","改分失败");
                            b3= false;
                            break;
                        }
                    }
                    if(b1 && b2 && b3){
                        int pscj = Integer.parseInt(p1);
                        int kscj = Integer.parseInt(p2);
                        double per = Double.parseDouble(PercentageOfPscj);
                        OpenServiceImpl openService = new OpenServiceImpl();
                        Open open = openService.getOpenByKhAndGh(kh,gh);
                        if(open==null){
                            request.getSession().setAttribute("updateStat","改分失败");
                        }else{
                            Elective elective = new Elective(xh,open);
                            boolean success = electiveService.updateElectiveWithGhAndGrade(elective,pscj,kscj,per);
                            if(success){
                                request.getSession().setAttribute("updateStat","改分成功");
                            }else{
                                request.getSession().setAttribute("updateStat","改分失败");
                            }
                        }
                    }
                }
            }

        }
        else{
            request.getSession().setAttribute("updateStat","改分失败");
        }
        List<Elective> electiveList = electiveService.getElectiveListByGh(gh);
        request.getSession().setAttribute("teacher",teacher);
        request.getSession().setAttribute("electiveList",electiveList);
        response.sendRedirect("/teacher.jsp");
    }
}
