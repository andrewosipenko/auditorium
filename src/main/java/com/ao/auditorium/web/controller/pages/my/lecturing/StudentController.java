package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.TransactionService;
import com.ao.auditorium.model.course.MentorCourseInvite;
import com.ao.auditorium.model.course.MentorCourseInviteRepository;
import com.ao.auditorium.model.student.StudentCourseInvite;
import com.ao.auditorium.model.student.StudentCourseInviteRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.annotation.Resource;
import java.util.UUID;
import java.util.Optional;

@Controller
public class StudentController {

    @Resource
    private StudentCourseInviteRepository studentCourseInviteRepository;
    @Resource
    private MentorCourseInviteRepository mentorCourseInviteRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/my/lecturing-courses/{courseId}/invite-student")
    @ResponseBody
    public ResponseEntity<String> sendStudentInvite(@RequestParam("email") String email, @PathVariable Long courseId) {
        try {
            transactionService.CreateStudentInvite(email,courseId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/my/lecturing-courses/{courseId}/invite-mentor")
    @ResponseBody
    public ResponseEntity<String> sendMentorInvite(@RequestParam("email") String email, @PathVariable Long courseId) {
        try {
            transactionService.CreateMentorInvite(email,courseId);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/apply-to-course/{uuid}/student")
    public String showStudentInvite(Model model, @PathVariable UUID uuid) {
        Optional<StudentCourseInvite> courseInvite = studentCourseInviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            model.addAttribute("courseInvite", courseInvite.get());
        }
        return WebConstants.Pages.APPLYING_STUDENT;
    }

    @GetMapping("/apply-to-course/{uuid}/mentor")
    public String showMentorInvite(Model model, @PathVariable UUID uuid) {
        Optional<MentorCourseInvite> courseInvite = mentorCourseInviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            model.addAttribute("courseInvite", courseInvite.get());
        }
        return WebConstants.Pages.APPLYING_MENTOR;
    }

    @GetMapping("/apply-to-course/{uuid}/student/apply")
    public String applyStudent(Model model, @PathVariable UUID uuid, RedirectAttributes redirectAttributes) {
        Optional<StudentCourseInvite> courseInvite = studentCourseInviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            StudentCourseInvite invite = courseInvite.get();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            try {
                transactionService.AddStudent(authentication, invite);
            }catch (Exception e){
                return "redirect:/"+WebConstants.Pages.APPLYING_STUDENT;
            }
            redirectAttributes.addFlashAttribute("message", "You were successfully invited to the course");
            return "redirect:/" + WebConstants.Pages.MY_COURSES_FOLDER + Long.toString(invite.getCourse().getId());
        }
        return WebConstants.Pages.APPLYING_STUDENT;
    }

    @GetMapping("/apply-to-course/{uuid}/mentor/apply")
    public String applyMentor(Model model, @PathVariable UUID uuid, RedirectAttributes redirectAttributes) {
        Optional<MentorCourseInvite> courseInvite = mentorCourseInviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            MentorCourseInvite invite = courseInvite.get();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            try {
                transactionService.AddMentor(authentication, invite);
            }catch (Exception e){
                return "redirect:/"+WebConstants.Pages.APPLYING_MENTOR;
            }
            redirectAttributes.addFlashAttribute("message", "You were successfully invited to the course");
            return "redirect:/" + WebConstants.Pages.MY_COURSES_FOLDER + Long.toString(invite.getCourse().getId());
        }
        return WebConstants.Pages.APPLYING_MENTOR;
    }

}
