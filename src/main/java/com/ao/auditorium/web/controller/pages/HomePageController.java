package com.ao.auditorium.web.controller.pages;

import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class HomePageController {
    @Resource
    private CourseRepository courseRepository;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return WebConstants.Pages.HOME;
    }
}
