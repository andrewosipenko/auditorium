package com.ao.auditorium.model.course;

import javax.persistence.*;

@Entity
public class CourseStudent {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    @ManyToOne
    @JoinColumn(name="student_id")
    private User student;
    @ManyToOne
    @JoinColumn(name="mentor_id")
    private User mentor;

    private String studentSourceRepository;

    public CourseStudent(Course course, User student){
        this.course = course;
        this.student = student;
        this.mentor = null;
        this.studentSourceRepository = null;
    }
}
