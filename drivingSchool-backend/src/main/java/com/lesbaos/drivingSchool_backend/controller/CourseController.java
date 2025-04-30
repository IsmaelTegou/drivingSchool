package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.data.Course;
import com.lesbaos.drivingSchool_backend.dto.CarResponseDTO;
import com.lesbaos.drivingSchool_backend.dto.CourseRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CourseResponseDTO;
import com.lesbaos.drivingSchool_backend.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/createCourse")
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.createCourse(courseRequestDTO));
    }

    @PutMapping("/updateCourse/{id}")
    public ResponseEntity<CourseResponseDTO> updateCourse(@PathVariable Long id, @RequestBody CourseRequestDTO courseRequestDTO) {
        return ResponseEntity.ok(courseService.updateCourse(id, courseRequestDTO));
    }

    @DeleteMapping("/deleteCourse/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findCourseById/{id}")
    public ResponseEntity<CourseResponseDTO> findCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @GetMapping("/findAllCourses")
    public ResponseEntity<List<CourseResponseDTO>> findAllCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }
}
