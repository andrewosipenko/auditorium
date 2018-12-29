package com.ao.auditorium.model.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CourseFile {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private Long course;
    private String type;
    private String name;

    @Lob
    private byte[] data;

    protected CourseFile(){}

    public CourseFile(Long course, byte[] data, String type, String name) {
        this.course = course;
        this.data = data;
        this.type = type;
        this.name = name;
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
}
