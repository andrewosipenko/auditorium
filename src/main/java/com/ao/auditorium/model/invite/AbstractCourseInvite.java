package com.ao.auditorium.model.invite;

import com.ao.auditorium.model.course.Course;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public abstract class AbstractCourseInvite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    UUID  uuid;
    String email;
    @ManyToOne
    @JoinColumn(name="course_id")
    Course course;
    CourseInviteStatus status;

    LocalDateTime date;

    public AbstractCourseInvite(){}

    public AbstractCourseInvite(String email, Course course, UUID uuid) {
        this.uuid = uuid;
        this.email = email;
        this.course = course;
        this.status = CourseInviteStatus.NEW;
        this.date = LocalDateTime.now();
    }

    public Course getCourse() {
        return course;
    }

    public void setStatus(int status) {
        this.status = CourseInviteStatus.valueOf(status);
    }

    public String getEmail() {
        return email;
    }

    public CourseInviteStatus getStatus() {
        return status;
    }

    public UUID getUuid() {
        return uuid;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
