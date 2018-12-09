package com.ao.auditorium.web.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DummyCourseLecturesController {
    @GetMapping("/my/lecturing-courses/xxx/lectures")
    public String getLectures(){
        return "/courseLectures";
    }
}
