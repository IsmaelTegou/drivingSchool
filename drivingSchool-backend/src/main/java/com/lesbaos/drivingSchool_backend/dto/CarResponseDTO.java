package com.lesbaos.drivingSchool_backend.dto;

import com.lesbaos.drivingSchool_backend.enumerations.StatutCar;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarResponseDTO {
    private Long id;
    private String registration;
    private String brand;
    private String model;
    private String color;
    private Boolean isOut;
    private Long adminId;
}
