package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class BasicCourseInfoPageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/my/lecturing-courses/{courseCode}")
    public String showCourse(@PathVariable String courseCode, @ModelAttribute CourseForm courseForm, Model model) {
        Course course = courseRepository.findByCode(courseCode).get();
        courseForm.setCode(course.getCode());
        courseForm.setName(course.getName());
        courseForm.setDescription(course.getDescription());
        model.addAttribute("course", courseRepository.findByCode(courseCode));
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourse";
    }

    @GetMapping("/my/lecturing-courses/")
    public String showCreateCourse(@ModelAttribute CourseForm courseForm) {
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourse";
    }

    @PostMapping("/my/lecturing-courses/")
    public RedirectView createCourse(RedirectAttributes attributes, @ModelAttribute CourseForm courseForm){
        Course newCourse = new Course(courseForm.getName(),courseForm.getCode(),courseForm.getDescription());
        courseRepository.save(newCourse);
        attributes.addFlashAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }

    @PostMapping("/my/lecturing-courses/{courseCode}")
    public RedirectView updateCourse(@PathVariable String courseCode, RedirectAttributes attributes, @ModelAttribute CourseForm courseForm){
        Course course = courseRepository.findByCode(courseCode).get();
        course.setName(courseForm.getName());
        course.setCode(courseForm.getCode());
        course.setDescription(courseForm.getDescription());
        courseRepository.save(course);
        attributes.addFlashAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }

    @PostMapping("/my/lecturing-courses/{courseCode}/delete")
    public RedirectView deleteCourse(@PathVariable String courseCode, RedirectAttributes attributes){
        courseRepository.findByCode(courseCode)
                .map(Course::getId)
                .ifPresent(courseRepository::deleteById);
        attributes.addFlashAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }
}
