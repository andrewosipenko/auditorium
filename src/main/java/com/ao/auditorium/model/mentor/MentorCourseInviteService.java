package com.ao.auditorium.model.mentor;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import com.ao.auditorium.model.user.User;
import com.ao.auditorium.model.user.UserRepository;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.UUID;

@Service
public class MentorCourseInviteService {
    @Resource
    private MentorCourseInviteRepository mentorCourseInviteRepository;

    @Resource
    private CourseRepository courseRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private CourseMentorRepository courseMentorRepository;

    @Resource
    private JavaMailSender emailSender;

    private void sendMentorInvite(String to, String course, String description, UUID uuid) throws Exception {
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
                "    Dear mentor,<br>\n" +
                "    you are invited to teach "+course+" course.<br>\n" +
                "    "+description+"<br>\n" +
                "    Click\n" +
                "    <a href=\"http://localhost:8080/apply-to-course/"+uuid+"/mentor\" >Confirm</a>\n" +
                "     to apply.\n" +
                "  </body>\n" +
                "</html>";
        helper.setText(text,true);
        emailSender.send(message);
    }

    @Transactional(rollbackFor = Exception.class)
    public void CreateMentorInvite(String email, Long coursecode) throws Exception {
        Course course = courseRepository.findById(coursecode).get();
        UUID uuid = UUID.randomUUID();
        MentorCourseInvite courseInvite = new MentorCourseInvite(email,course,uuid);
        mentorCourseInviteRepository.save(courseInvite);
        sendMentorInvite(email,course.getName(),course.getDescription(),uuid);
    }

    @Transactional(rollbackFor = Exception.class)
    public void AddMentor(Authentication authentication, MentorCourseInvite invite) throws Exception {
        invite.setStatus(2);
        HashMap data = (HashMap) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        String login = data.get("login").toString();
        if (!userRepository.findByLogin(login).isPresent()){
            String name = data.get("name").toString();
            User newUser = new User(login,name,invite.getEmail());
            userRepository.save(newUser);
        }
        User user = userRepository.findByLogin(login).get();
        CourseMentor mentor = new CourseMentor(invite.getCourse(),user);
        courseMentorRepository.save(mentor);
        invite.setUser(mentor);
    }
}
