package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.TransactionService;
import com.ao.auditorium.model.student.CourseInvite;
import com.ao.auditorium.model.student.CourseInviteRepository;
import com.ao.auditorium.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.UUID;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @javax.annotation.Resource
    private CourseInviteRepository courseInviteRepository;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/my/lecturing-courses/{coursecode}/invite")
    @ResponseBody
    public ResponseEntity<String> sendInvite(@RequestParam("email") String email, @PathVariable Long coursecode) {
        try {
            transactionService.CreateInvite(email,coursecode);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/apply-to-course/{uuid}")
    public String showInvite(Model model, @PathVariable UUID uuid) {
        Optional<CourseInvite> courseInvite = courseInviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            model.addAttribute("courseInvite", courseInvite.get());
        }
        return WebConstants.Pages.APPLYING_TO_COURSE;
    }

    @GetMapping("/apply-to-course/{uuid}/apply")
    public String apply(Model model, @PathVariable UUID uuid, RedirectAttributes redirectAttributes) {
        Optional<CourseInvite> courseInvite = courseInviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            CourseInvite invite = courseInvite.get();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            try {
                transactionService.FillDB(authentication, invite);
            }catch (Exception e){
                model.addAttribute("courseInvite", courseInvite.get());
                return WebConstants.Pages.APPLYING_TO_COURSE;
            }
            redirectAttributes.addFlashAttribute("message", "You were successfully invited to the course");
            return "redirect:/" + WebConstants.Pages.MY_COURSES_FOLDER + Long.toString(invite.getCourse().getId());
        }
        return WebConstants.Pages.APPLYING_TO_COURSE;
    }

}
