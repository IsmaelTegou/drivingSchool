package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Course;
import com.lesbaos.drivingSchool_backend.dto.CourseRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    public void deleteCourse(Long id);
    public Course findCourseById(Long id);
    public CourseResponseDTO getCourseById(Long id);
    public List<CourseResponseDTO> findAllCourses();
}
