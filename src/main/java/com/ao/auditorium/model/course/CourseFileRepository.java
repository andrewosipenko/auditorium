package com.ao.auditorium.model.course;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import org.springframework.core.io.Resource;

public interface CourseFileRepository extends CrudRepository<CourseFile, Long> {
    List<CourseFile> findByCourse(Course course);
    Optional<CourseFile> findByName(String name);
    void deleteByName(String name);
}
