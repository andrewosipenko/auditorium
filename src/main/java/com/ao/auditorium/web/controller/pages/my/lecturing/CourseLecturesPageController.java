package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;

@Controller
public class CourseLecturesPageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/my/lecturing-courses/{courseCode}/lectures")
    public String showLectures(@PathVariable String courseCode, Model model){
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        return WebConstants.Pages.COURSE_LECTURES;
    }
}
