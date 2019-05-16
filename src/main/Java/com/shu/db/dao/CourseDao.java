package com.shu.db.dao;

import com.shu.db.entity.Course;
import java.util.List;

/**
 * Created by PoleToWin on 2019/5/1 17:50
 */
public interface CourseDao {
    Course getCourse(String kh);
    List<Course> getCourseList();
    List<Course> getCourseListbyYxh(String yxh);
    void insertCourse(Course course);
    void deleteCourse(String kh);
    void updateCourse(Course course);
}
