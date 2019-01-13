package com.ao.auditorium.model.student;


import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
public class CourseInvite {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private UUID  uuid;
    private String email;
    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    private CourseInviteStatus status;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    private LocalDateTime date;

    protected CourseInvite(){}

    public CourseInvite(String email, Course course, UUID uuid) {
        this.uuid = uuid;
        this.email = email;
        this.course = course;
        this.status = CourseInviteStatus.NEW;
        this.user = null;
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

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
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


