package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.mentor.MentorCourseInviteService;
import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.model.mentor.MentorCourseInviteRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class CourseMentorsPageController {
    @Resource
    private CourseRepository courseRepository;

    @Resource
    private MentorCourseInviteRepository mentorCourseInviteRepository;

    @Resource
    private MentorCourseInviteService mentorCourseInviteService;

    @GetMapping("/my/lecturing-courses/{courseCode}/mentors")
    public String showMentors(@PathVariable String courseCode, Model model) {
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        model.addAttribute("invites", mentorCourseInviteRepository.findByCourse(course));
        return WebConstants.Pages.MY_LECTURING_FOLDER+"courseMentors";
    }

    @PostMapping("/my/lecturing-courses/{courseId}/invite-mentor")
    @ResponseBody
    public ResponseEntity<String> sendMentorInvite(@RequestParam("email") String email, @PathVariable Long courseId) {
        try {
            mentorCourseInviteService.CreateMentorInvite(email,courseId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
