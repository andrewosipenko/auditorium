package com.ao.auditorium.web.controller.pages.my.lecturing;


import com.ao.auditorium.model.course.*;
import com.ao.auditorium.model.user.UserService;
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
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @javax.annotation.Resource
    private CourseInviteRepository inviteRepository;
    @javax.annotation.Resource
    private CourseRepository courseRepository;
    @javax.annotation.Resource
    private UserRepository userRepository;
    @javax.annotation.Resource
    private CourseStudentRepository courseStudentRepository;
    @Resource
    private UserService userService;

    @Autowired
    public JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String course, String description, UUID uuid) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo(to);
        helper.setSubject(course+" course invitation");
        String text = "<html>\n" +
                "  <head>\n" +
                "    <style>\n" +
                "      a {\n" +
                "            color: #fff !important;\n" +
                "            text-transform: uppercase;\n" +
                "            text-decoration: none;\n" +
                "            background: blue;\n" +
                "            padding: 5px;\n" +
                "            border-radius: 5px;\n" +
                "            border: none;\n" +
                "          }\n" +
                "    </style>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "    Dear student,<br>\n" +
                "    you are invited to pass "+course+" course.<br>\n" +
                "    "+description+"<br>\n" +
                "    Click\n" +
                "    <a href=\"localhost:8080/apply-to-course/"+uuid+"\" >Confirm</a>\n" +
                "     to apply.\n" +
                "  </body>\n" +
                "</html>";
        helper.setText(text,true);
        emailSender.send(message);
    }

    @PostMapping("/my/lecturing-courses/{coursecode}/invite")
    @ResponseBody
    public ResponseEntity<String> sendInvite(@RequestParam("email") String email, @PathVariable Long coursecode) {
        try {
            Course course = courseRepository.findById(coursecode).get();
            UUID uuid = UUID.randomUUID();
            CourseInvite courseInvite = new CourseInvite(email,course,uuid);
            inviteRepository.save(courseInvite);
            sendSimpleMessage(email,course.getName(),course.getDescription(),uuid);
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/apply-to-course/{uuid}")
    public String showInvite(Model model, @PathVariable UUID uuid) {
        Optional<CourseInvite> courseInvite = inviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            model.addAttribute("courseInvite", courseInvite.get());
        }
        return WebConstants.Pages.APPLYING_TO_COURSE;
    }
    @GetMapping("/apply-to-course/{uuid}/apply")
    public String apply(Model model, @PathVariable UUID uuid, RedirectAttributes redirectAttributes) {
        Optional<CourseInvite> courseInvite = inviteRepository.findByUuid(uuid);
        if (courseInvite.isPresent()) {
            CourseInvite invite = courseInvite.get();
            invite.setStatus(2);
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            FillDB(authentication, invite);
            redirectAttributes.addFlashAttribute("message", "You were successfully invited to the course");
            return "redirect:/my/courses/" + Long.toString(invite.getCourse().getId());
        }
        return WebConstants.Pages.APPLYING_TO_COURSE;
    }

    private void FillDB(Authentication authentication, CourseInvite invite){
        User user = userService.loadCurrentUser();
        if (user.getEmail() == null) {
            user.setEmail(invite.getEmail());
        }
        userRepository.save(user);
        invite.setUser(user);
        CourseStudent student = new CourseStudent(invite.getCourse(),user);
        courseStudentRepository.save(student);
    }
}
