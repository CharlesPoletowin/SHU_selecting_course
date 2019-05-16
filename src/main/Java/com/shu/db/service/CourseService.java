package com.shu.db.service;

import com.shu.db.entity.Course;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 18:01
 */
public interface CourseService {
    Course getCourseByKh(String kh);
    List<Course> getCourseList();
    List<Course> getCourseListbyYxh(String yxh);
}
