package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;

@Controller()
public class MyLecturingCoursesPageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/my/lecturing-courses")
    public String showAllCourses(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourses";
    }

    @GetMapping("/my/lecturing-courses/")
    public String createCourse(Model model) {
        model.addAttribute("course", null);
        model.addAttribute("courseId", 0 );
        return WebConstants.Pages.MY_LECTURING_FOLDER+"lecturingCourse";
    }

    @GetMapping("/my/lecturing-courses/{courseId}")
    public String updateCourse(@PathVariable String courseId, Model model) {
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
    public RedirectView saveCourse(@PathVariable Long courseId,RedirectAttributes attributes,@ModelAttribute CourseForm courseForm){
        if (courseRepository.findById(courseId).isPresent()) {
            Course course = courseRepository.findById(courseId).get();
            course.setName(courseForm.getName());
            course.setCode(courseForm.getCode());
            course.setDescription(courseForm.getDescription());
            courseRepository.save(course);
        }else{
            Course newCourse = new Course(courseForm.getName(),courseForm.getCode(),courseForm.getDescription());
            courseRepository.save(newCourse);
        }
        attributes.addFlashAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }

    @PostMapping("/my/lecturing-courses/{courseId}/delete")
    public RedirectView deleteCourse(@PathVariable Long courseId,RedirectAttributes attributes){
        if (courseRepository.findById(courseId).isPresent())
            courseRepository.deleteById(courseId);
        attributes.addFlashAttribute("status", "success");
        return new RedirectView("/my/lecturing-courses");
    }

}
