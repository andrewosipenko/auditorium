package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.Optional;

@Controller()
public class MyLecturingCoursesPageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/my/lecturing-courses")
    public String showAllCourses(Model model,@RequestParam("status") Optional<String> status) {
        model.addAttribute("courses", courseRepository.findAll());
        if (status.isPresent())
            model.addAttribute("status", status.get());
        else
            model.addAttribute("status", null);
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourses";
    }

    @GetMapping("/my/lecturing-courses/")
    public String createCourses(Model model) {
        model.addAttribute("course", null);
        model.addAttribute("courseId", 0 );
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourse";
    }

    @GetMapping("/my/lecturing-courses/{courseId}")
    public String updateCourses(@PathVariable String courseId, Model model) {
        Long num;
        try
        {
            num = Long.parseLong(courseId);
        }
        catch(NumberFormatException nfe)
        {
            model.addAttribute("course", null);
            model.addAttribute("courseId", 0 );
            return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourse";
        }
        model.addAttribute("courseId", num);
        model.addAttribute("course", courseRepository.findById(num));
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourse";
    }

    @PostMapping("/my/lecturing-courses/{courseId}")
    public RedirectView redirect(@PathVariable Long courseId,RedirectAttributes attributes,@RequestParam("courseName") String code,@RequestParam("courseName") String name,@RequestParam("courseDescription") String description){
        if (courseRepository.findById(courseId).isPresent()) {
            Course course = courseRepository.findById(courseId).get();
            course.setName(name);
            course.setCode(code);
            course.setDescription(description);
            courseRepository.save(course);
        }else{
            Course newCourse = new Course(code,name,description);
            courseRepository.save(newCourse);
        }
        attributes.addAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }

    @PostMapping("/my/lecturing-courses/{courseId}/delete")
    public RedirectView redirect(@PathVariable Long courseId,RedirectAttributes attributes){
        courseRepository.deleteById(courseId);
        attributes.addAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }

}
