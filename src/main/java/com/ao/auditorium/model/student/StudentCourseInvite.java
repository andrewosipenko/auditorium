package com.ao.auditorium.model.student;


import com.ao.auditorium.model.AbstractCourseInvite;
import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.user.User;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class StudentCourseInvite extends AbstractCourseInvite {

    @OneToOne
    @JoinColumn(name="course_student_id")
    CourseStudent user;

    public StudentCourseInvite(){}

    public StudentCourseInvite(String email, Course course, UUID uuid) {
        super(email,course,uuid);
        this.user = null;
    }

    public void setUser(CourseStudent user) {
        this.user = user;
    }

    public CourseStudent getUser() {
        return user;
    }

}


