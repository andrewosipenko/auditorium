package com.ao.auditorium.model.user;

import com.ao.auditorium.model.course.CourseInvite;
import com.ao.auditorium.model.course.User;
import com.ao.auditorium.model.course.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public User loadCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return mayBeCreateUser(authentication);
    }

    private User mayBeCreateUser(Authentication authentication) {
        HashMap data = (HashMap) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        String login = data.get("login").toString();
        return userRepository.findByLogin(login).orElseGet(() -> createUser(authentication));
    }
    private User createUser(Authentication authentication) {
        HashMap data = (HashMap) ((OAuth2Authentication) authentication).getUserAuthentication().getDetails();
        String login = data.get("login").toString();
        String name = data.get("name").toString();
        User user = new User(login, name,null);
        userRepository.save(user);
        return user;
    }
}
