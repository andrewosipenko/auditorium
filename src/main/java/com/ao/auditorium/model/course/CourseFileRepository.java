package com.ao.auditorium.model.course;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.springframework.core.io.Resource;

public interface CourseFileRepository extends CrudRepository<CourseFile, Long> {
    Optional<CourseFile> findByCourse(Long course);
    Optional<CourseFile> findByName(String name);
}
