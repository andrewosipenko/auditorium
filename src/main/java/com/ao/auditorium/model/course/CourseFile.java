package com.ao.auditorium.model.course;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CourseFile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    @ManyToOne
    @JoinColumn(name="course_id")
    Course course;
    String type;
    String name;
    LocalDateTime date;

    @Lob
    private byte[] data;

    protected CourseFile(){}

    public CourseFile(Course course, byte[] data, String type, String name) {
        this.course = course;
        this.data = data;
        this.type = type;
        this.name = name;
        this.date = LocalDateTime.now();
    }

    public Long getId(){
        return  this.id;
    }

    public String getType() {
        return this.type;
    }

    public byte[] getData() {
        return this.data;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public double getSize() {
        return (double) data.length/1048576;
    }

    public boolean isImage(){
        if (type.substring(0, 5).equals("image"))
            return true;
        else
            return false;
    }

    public String getFileLocation(){
        return "/my/lecturing-courses/"+course.getId()+"/files/"+this.name;
    }
}
