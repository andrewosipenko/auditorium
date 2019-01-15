package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.model.student.CourseInviteRepository;
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
    @Resource
    private CourseInviteRepository courseInviteRepository;

    @GetMapping("/my/lecturing-courses/{courseCode}/lectures")
    public String showLectures(@PathVariable String courseCode, Model model){
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        return WebConstants.Pages.COURSE_LECTURES;
    }


    @GetMapping("/my/lecturing-courses/{courseCode}/students")
    public String ListStudents(@PathVariable String courseCode, Model model) {
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        model.addAttribute("invites", courseInviteRepository.findByCourse(course));
        return WebConstants.Pages.MY_LECTURING_FOLDER+"courseStudents";
    }

    @GetMapping("/my/lecturing-courses/{courseCode}/mentors")
    public String ListMentors(@PathVariable String courseCode, Model model) {
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        return WebConstants.Pages.MY_LECTURING_FOLDER+"studentList";
    }
}
