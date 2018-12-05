package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class MyLecturingCoursesPageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/my/courses")
    public String showAllCourses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourses";
    }
}
