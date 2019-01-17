package com.ao.auditorium.model.course;

import com.ao.auditorium.model.student.StudentCourseInvite;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MentorCourseInviteRepository extends CrudRepository<MentorCourseInvite, Long> {
    Optional<MentorCourseInvite> findByUuid(UUID uuid);
    List<MentorCourseInvite> findByCourse(Course course);
}
