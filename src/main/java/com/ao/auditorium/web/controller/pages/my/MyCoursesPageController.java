package com.ao.auditorium.web.controller.pages.my;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseStudent;
import com.ao.auditorium.model.course.CourseStudentRepository;
import com.ao.auditorium.model.course.User;
import com.ao.auditorium.model.user.UserService;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MyCoursesPageController {
    @Resource
    private CourseStudentRepository courseStudentRepository;
    @Resource
    private UserService userService;

    @GetMapping("/my/courses")
    public String showMyCourses(Model model) {
        User user = userService.loadCurrentUser();
        List<Course> courses = courseStudentRepository.findByStudent(user).stream()
                .map(CourseStudent::getCourse)
                .collect(Collectors.toList());
        model.addAttribute("courses", courses);
        return WebConstants.Pages.MY_COURSES;
    }
}
