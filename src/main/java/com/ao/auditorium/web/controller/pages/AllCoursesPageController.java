package com.ao.auditorium.web.controller.pages;

import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller
public class AllCoursesPageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/courses")
    public String showAllCourses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return WebConstants.Pages.ALL_COURSES;
    }

    @GetMapping("/courses/{courseCode}")
    public String showAllCourses(@PathVariable String courseCode, Model model) {
        return WebConstants.Pages.COURSE;
    }
}
