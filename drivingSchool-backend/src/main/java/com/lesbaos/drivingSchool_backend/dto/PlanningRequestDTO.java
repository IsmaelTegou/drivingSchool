package com.lesbaos.drivingSchool_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanningRequestDTO {
    @NotBlank
    private String title;

    @NotNull
    private Long administratorId;

}
