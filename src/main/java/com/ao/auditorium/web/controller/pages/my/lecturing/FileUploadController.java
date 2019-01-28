package com.ao.auditorium.web.controller.pages.my.lecturing;

import com.ao.auditorium.model.course.*;
import com.ao.auditorium.web.WebConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.Optional;
import java.io.IOException;
import java.util.Base64;

@Controller
public class FileUploadController {

    @Resource
    private CourseFileRepository fileRepository;
    @Resource
    private CourseRepository courseRepository;

    @Resource
    private CourseFileService courseFileService;

    @GetMapping("/my/lecturing-courses/{coursecode}/files/{filename}")
    @ResponseBody
    public ResponseEntity<byte[]> serveFile(@PathVariable String filename) {
        if (!fileRepository.findByName(filename).isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        CourseFile file = fileRepository.findByName(filename).get();
        byte[] image = file.getData();
        HttpHeaders headers = new HttpHeaders();
        String[] type = file.getType().split("/");
        headers.setContentType(new MediaType(type[0],type[1]));
        return ResponseEntity.ok()
                .headers(headers)
                .body(image);
    }

    @PostMapping("/my/lecturing-courses/{coursecode}/files")
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file, @PathVariable Long coursecode) {
        try {
            courseFileService.AddFile(file,coursecode);
            String filestring = "/my/lecturing-courses/"+coursecode+"/files/"+file.getOriginalFilename();
            return ResponseEntity.ok("{\"location\":\""+filestring+"\"}");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/my/lecturing-courses/{coursecode}/files/{filename}/delete")
    public RedirectView deleteCourse(@PathVariable String coursecode, @PathVariable String filename, RedirectAttributes attributes){
        try {
            courseFileService.DeleteFile(filename);
            attributes.addFlashAttribute("status", "success");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new RedirectView("/my/lecturing-courses/{coursecode}/files");
    }


    @GetMapping("/my/lecturing-courses/{courseCode}/files")
    public String ListFiles(@PathVariable String courseCode, Model model) {
        Course course = courseRepository.findByCode(courseCode).get();
        model.addAttribute("course", course);
        model.addAttribute("files", fileRepository.findByCourse(course));
        return WebConstants.Pages.COURSE_FILES;
    }

}