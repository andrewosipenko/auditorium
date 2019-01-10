package com.ao.auditorium.model.course;


import java.util.HashMap;
import java.util.Map;
import javax.persistence.*;
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

    enum CourseInviteStatus {
        NEW(0),
        OPENED(1),
        CONFIRMED(2);

        private int value;
        private static Map map = new HashMap<>();

        CourseInviteStatus(int value) {
            this.value = value;
        }

        static {
            for (CourseInviteStatus status : CourseInviteStatus.values()) {
                map.put(status.value, status);
            }
        }

        public static CourseInviteStatus valueOf(int status) {
            return (CourseInviteStatus) map.get(status);
        }

        public int getValue() {
            return value;
        }
    }

    protected CourseInvite(){}

    public CourseInvite(String email, Course course, UUID uuid) {
        this.uuid = uuid;
        this.email = email;
        this.course = course;
        this.status = CourseInviteStatus.NEW;
        this.user = null;
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

    public UUID getUuid() {
        return uuid;
    }
}


