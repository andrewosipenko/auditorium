package com.ao.auditorium.model.course;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseStudentRepository extends CrudRepository<CourseStudent, Long>{
    List<CourseStudent> findByStudent(User user);
}
