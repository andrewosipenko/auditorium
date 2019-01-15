package com.ao.auditorium;

import com.ao.auditorium.model.course.*;
import com.ao.auditorium.model.student.CourseInvite;
import com.ao.auditorium.model.student.CourseInviteRepository;
import com.ao.auditorium.model.student.CourseStudent;
import com.ao.auditorium.model.student.CourseStudentRepository;
import com.ao.auditorium.model.user.User;
import com.ao.auditorium.model.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {

    @javax.annotation.Resource
    private CourseInviteRepository inviteRepository;
    @javax.annotation.Resource
    private CourseRepository courseRepository;
    @javax.annotation.Resource
    private UserRepository userRepository;
    @javax.annotation.Resource
    private CourseStudentRepository courseStudentRepository;


    @Autowired
    private JavaMailSender emailSender;

    private void sendSimpleMessage(String to, String course, String description, UUID uuid) throws Exception {
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

    @Transactional(rollbackFor = Exception.class)
    public void CreateInvite(String email, Long coursecode) throws Exception {
        Course course = courseRepository.findById(coursecode).get();
        UUID uuid = UUID.randomUUID();
        CourseInvite courseInvite = new CourseInvite(email,course,uuid);
        inviteRepository.save(courseInvite);
        sendSimpleMessage(email,course.getName(),course.getDescription(),uuid);
    }

    @Transactional(rollbackFor = Exception.class)
    public void FillDB(Authentication authentication, CourseInvite invite) throws Exception {
        invite.setStatus(2);
        HashMap data = (HashMap) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        String login = data.get("login").toString();
        if (!userRepository.findByLogin(login).isPresent()){
            String name = data.get("name").toString();
            User newUser = new User(login,name,invite.getEmail());
            userRepository.save(newUser);
        }
        User user = userRepository.findByLogin(login).get();
        invite.setUser(user);
        CourseStudent student = new CourseStudent(invite.getCourse(),user);
        courseStudentRepository.save(student);
    }
}
