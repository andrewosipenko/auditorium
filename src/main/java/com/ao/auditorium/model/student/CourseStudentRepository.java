package com.ao.auditorium.model.student;

import com.ao.auditorium.model.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseStudentRepository extends CrudRepository<CourseStudent, Long>{
    List<CourseStudent> findByStudent(User user);
}
