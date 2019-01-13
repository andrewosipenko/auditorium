package com.ao.auditorium.model.student;

import com.ao.auditorium.model.course.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface CourseInviteRepository extends CrudRepository<CourseInvite, Long> {
    Optional<CourseInvite> findByUuid(UUID uuid);
    List<CourseInvite> findByCourse(Course course);
}
