package com.lesbaos.drivingSchool_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarRequestDTO {
    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotBlank
    private String color;

    @NotBlank
    private String registration;

    @NotBlank
    private Boolean isOut;

    @NotNull
    private Long adminId;
}
