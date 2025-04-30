package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.CourseRepository;
import com.lesbaos.drivingSchool_backend.data.Course;
import com.lesbaos.drivingSchool_backend.dto.CourseRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.CourseResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import com.lesbaos.drivingSchool_backend.service.CourseService;
import com.lesbaos.drivingSchool_backend.service.InstructorService;
import com.lesbaos.drivingSchool_backend.service.PlanningService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourseServiceImplement implements CourseService {
    private final CourseRepository courseRepository;
    private final InstructorService instructorService;
    private final AdministratorService administratorService;
    private final PlanningService planningService;

    public CourseServiceImplement(CourseRepository courseRepository, InstructorService instructorService, AdministratorService administratorService, PlanningService planningService) {
        this.courseRepository = courseRepository;
        this.instructorService = instructorService;
        this.administratorService = administratorService;
        this.planningService = planningService;
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Course course = Course.builder()
                .name(courseRequestDTO.getName())
                .creationDate(LocalDateTime.now())
                .location(courseRequestDTO.getLocation())
                .typeCourse(courseRequestDTO.getTypeCourse())
                .instructor(instructorService.findInstructorById(courseRequestDTO.getInstructorId()))
                .administrator(administratorService.findAdministratorById(courseRequestDTO.getAdministratorId()))
                .planning(planningService.findPlanningById(courseRequestDTO.getPlanningId()))
                .build();
        courseRepository.save(course);
        return mapToCourseResponseDTO(course);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Course course  = Course.builder()
                .name(courseRequestDTO.getName())
                .typeCourse(courseRequestDTO.getTypeCourse())
                .creationDate(LocalDateTime.now())
                .location(courseRequestDTO.getLocation())
                .instructor(instructorService.findInstructorById(courseRequestDTO.getInstructorId()))
                .administrator(administratorService.findAdministratorById(courseRequestDTO.getAdministratorId()))
                .planning(planningService.findPlanningById(courseRequestDTO.getPlanningId()))
                .build();
        courseRepository.save(course);

        return mapToCourseResponseDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = findCourseById(id);
        courseRepository.delete(course);
    }

    @Override
    public Course findCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Course with id %s not found", id))
        );
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = findCourseById(id);
        return mapToCourseResponseDTO(course);
    }

    @Override
    public List<CourseResponseDTO> findAllCourses() {
        return courseRepository.findAll().stream().map(this::mapToCourseResponseDTO).collect(Collectors.toList());
    }

    private CourseResponseDTO mapToCourseResponseDTO(Course course) {
        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .lastnameInstructor(course.getInstructor().getLastName())
                .creationDate(course.getCreationDate())
                .location(course.getLocation())
                .typeCourse(course.getTypeCourse())
                .lastnameAdmin(course.getAdministrator().getLastName())
                .titlePlanning(course.getPlanning().getTitle())
                .build();
    }
}
