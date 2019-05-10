package com.shu.db.entity;

/**
 * Created by PoleToWin on 2019/5/2 13:35
 */
public class CourseAndOpenAndTeacher {
    private Course course;
    private Open open;
    private Teacher teacher;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Open getOpen() {
        return open;
    }

    public void setOpen(Open open) {
        this.open = open;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public CourseAndOpenAndTeacher(Course course, Open open, Teacher teacher) {
        this.course = course;
        this.open = open;
        this.teacher = teacher;
    }
}
