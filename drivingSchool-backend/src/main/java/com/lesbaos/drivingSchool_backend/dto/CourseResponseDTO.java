package com.lesbaos.drivingSchool_backend.dto;

import com.lesbaos.drivingSchool_backend.enumerations.TypeCourse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CourseResponseDTO {
    private Long id;
    private String name;
    private String lastnameInstructor;
    private LocalDateTime creationDate;
    private String location;
    private TypeCourse typeCourse;
    private String lastnameAdmin;
    private String titlePlanning;
}
