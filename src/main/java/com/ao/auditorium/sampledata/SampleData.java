package com.ao.auditorium.sampledata;

import com.ao.auditorium.model.course.Course;
import com.ao.auditorium.model.course.CourseRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class SampleData implements ApplicationRunner {

    @Resource
    private CourseRepository courseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course java8course = new Course("java8", "Java 8", "Java 8 and streams training for juniours");
        courseRepository.save(java8course);

        Course servletApiCourse = new Course("servlet-api", "Servlet API", "Servlet API training for juniours");
        courseRepository.save(servletApiCourse);

        Course springMvcCourse = new Course("spring-mvc", "Spring MVC", "Spring MVC training for juniours");
        courseRepository.save(springMvcCourse);
    }
}

