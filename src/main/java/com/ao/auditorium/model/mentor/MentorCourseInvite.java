package com.ao.auditorium.model.mentor;


import com.ao.auditorium.model.invite.AbstractCourseInvite;
import com.ao.auditorium.model.course.Course;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.UUID;


@Entity
public class MentorCourseInvite extends AbstractCourseInvite {

    @OneToOne
    @JoinColumn(name="course_mentor_id")
    CourseMentor user;

    public MentorCourseInvite(){}

    public MentorCourseInvite(String email, Course course, UUID uuid) {
        super(email,course,uuid);
        this.user = null;
    }


    public void setUser(CourseMentor user) {
        this.user = user;
    }

    public CourseMentor getUser() {
        return user;
    }

}


