package com.ao.auditorium.model.course;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CourseFileService {

    @Resource
    private CourseRepository courseRepository;
    @Resource
    private CourseFileRepository fileRepository;

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
