package com.lesbaos.drivingSchool_backend.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlanningResponseDTO {
    private Long id;
    private String title;
    private String lastnameAdmin;
    private List<String> coursesNames;
}
