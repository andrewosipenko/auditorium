package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.model.student.StudentCourseInviteRepository;
import com.ao.auditorium.model.student.StudentCourseInviteService;
import com.ao.auditorium.web.WebConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class CourseStudentsPageController {
    @Resource
    private CourseRepository courseRepository;

    @Resource
    private StudentCourseInviteRepository studentCourseInviteRepository;

    @Resource
    private StudentCourseInviteService studentCourseInviteService;

    @GetMapping("/my/lecturing-courses/{courseCode}/students")
    public String ListStudents(@PathVariable String courseCode, Model model) {
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        model.addAttribute("invites", studentCourseInviteRepository.findByCourse(course));
        return WebConstants.Pages.MY_LECTURING_FOLDER+"courseStudents";
    }

    @PostMapping("/my/lecturing-courses/{courseId}/invite-student")
    @ResponseBody
    public ResponseEntity<String> sendStudentInvite(@RequestParam("email") String email, @PathVariable Long courseId) {
        try {
            studentCourseInviteService.CreateStudentInvite(email,courseId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
