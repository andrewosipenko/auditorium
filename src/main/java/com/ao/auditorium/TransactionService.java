package com.ao.auditorium;

import com.ao.auditorium.model.AbstractCourseInvite;
import com.ao.auditorium.model.course.*;
import com.ao.auditorium.model.student.StudentCourseInvite;
import com.ao.auditorium.model.student.StudentCourseInviteRepository;
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
import javax.annotation.Resource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
import java.util.HashMap;
import java.util.Map;

@Service
public class TransactionService {

    @Resource
    private StudentCourseInviteRepository studentCourseInviteRepository;
    @Resource
    private MentorCourseInviteRepository mentorCourseInviteRepository;
    @Resource
    private CourseRepository courseRepository;
    @Resource
    private UserRepository userRepository;
    @Resource
    private CourseStudentRepository courseStudentRepository;
    @Resource
    private CourseMentorRepository courseMentorRepository;
    @Resource
    private CourseFileRepository fileRepository;


    @Autowired
    private JavaMailSender emailSender;

    private void sendStudentInvite(String to, String course, String description, UUID uuid) throws Exception {
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
                "    <a href=\"localhost:8080/apply-to-course/"+uuid+"/student\" >Confirm</a>\n" +
                "     to apply.\n" +
                "  </body>\n" +
                "</html>";
        helper.setText(text,true);
        emailSender.send(message);
    }

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
                "    <a href=\"localhost:8080/apply-to-course/"+uuid+"/mentor\" >Confirm</a>\n" +
                "     to apply.\n" +
                "  </body>\n" +
                "</html>";
        helper.setText(text,true);
        emailSender.send(message);
    }

    @Transactional(rollbackFor = Exception.class)
    public void CreateStudentInvite(String email, Long coursecode) throws Exception {
        Course course = courseRepository.findById(coursecode).get();
        UUID uuid = UUID.randomUUID();
        StudentCourseInvite courseInvite = new StudentCourseInvite(email,course,uuid);
        studentCourseInviteRepository.save(courseInvite);
        sendStudentInvite(email,course.getName(),course.getDescription(),uuid);
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
    public void AddStudent(Authentication authentication, StudentCourseInvite invite) throws Exception {
        invite.setStatus(2);
        HashMap data = (HashMap) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        String login = data.get("login").toString();
        if (!userRepository.findByLogin(login).isPresent()){
            String name = data.get("name").toString();
            User newUser = new User(login,name,invite.getEmail());
            userRepository.save(newUser);
        }
        User user = userRepository.findByLogin(login).get();
        CourseStudent student = new CourseStudent(invite.getCourse(),user);
        courseStudentRepository.save(student);
        invite.setUser(student);
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

    @Transactional(rollbackFor = Exception.class)
    public void AddFile(MultipartFile file, Long coursecode) throws Exception {
        Course course = courseRepository.findById(coursecode).get();
        CourseFile courseFile = new CourseFile(course, file.getBytes(), file.getContentType(), file.getOriginalFilename());
        fileRepository.save(courseFile);
    }

    @Transactional(rollbackFor = Exception.class)
    public void DeleteFile(String filename) throws Exception {
        fileRepository.deleteByName(filename);
    }


}
