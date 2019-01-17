package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.mentor.MentorCourseInviteService;
import com.ao.auditorium.model.mentor.MentorCourseInvite;
import com.ao.auditorium.model.mentor.MentorCourseInviteRepository;
import com.ao.auditorium.model.student.StudentCourseInvite;
import com.ao.auditorium.model.student.StudentCourseInviteRepository;
import com.ao.auditorium.model.student.StudentCourseInviteService;
import com.ao.auditorium.web.WebConstants;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ApplyToCoursePageController {
    @Resource
    private StudentCourseInviteRepository studentCourseInviteRepository;

    @Resource
    private MentorCourseInviteRepository mentorCourseInviteRepository;

    @Resource
    private MentorCourseInviteService mentorCourseInviteService;

    @Resource
    private StudentCourseInviteService studentCourseInviteService;

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
                studentCourseInviteService.AddStudent(authentication, invite);
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
                mentorCourseInviteService.AddMentor(authentication, invite);
            }catch (Exception e){
                return "redirect:/"+WebConstants.Pages.APPLYING_MENTOR;
            }
            redirectAttributes.addFlashAttribute("message", "You were successfully invited to the course");
            return "redirect:/" + WebConstants.Pages.MY_COURSES_FOLDER + Long.toString(invite.getCourse().getId());
        }
        return WebConstants.Pages.APPLYING_MENTOR;
    }
}
