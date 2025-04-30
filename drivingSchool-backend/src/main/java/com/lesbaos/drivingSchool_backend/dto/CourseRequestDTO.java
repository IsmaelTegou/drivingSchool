package com.lesbaos.drivingSchool_backend.dto;

import com.lesbaos.drivingSchool_backend.enumerations.TypeCourse;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseRequestDTO {
    @NotNull
    private Long administratorId;

    @NotNull
    private Long planningId;

    @NotNull
    private Long instructorId;

    @NotNull
    private String name;

    @NotNull
    private String location;

    @NotNull
    private TypeCourse typeCourse;

}
