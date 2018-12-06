package com.ao.auditorium.web.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/my/lecturing-courses/xxx/lectures")
public class DummyCourseLecturesController {
    @GetMapping
    public String getLectures(){
        return "/courseLectures";
    }
}
