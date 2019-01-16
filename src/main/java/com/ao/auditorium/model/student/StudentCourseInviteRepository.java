package com.ao.auditorium.model.student;

import com.ao.auditorium.model.course.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface StudentCourseInviteRepository extends CrudRepository<StudentCourseInvite, Long> {
    Optional<StudentCourseInvite> findByUuid(UUID uuid);
    List<StudentCourseInvite> findByCourse(Course course);
}
