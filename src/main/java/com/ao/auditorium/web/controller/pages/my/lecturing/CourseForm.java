package com.ao.auditorium.web.controller.pages.my.lecturing;

public class CourseForm {

    private String code;
    private String name;
    private String description;

    public String getName(){
        return  this.name;
    }

    public String getDescription(){
        return  this.description;
    }

    public String getCode(){
        return  this.code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
