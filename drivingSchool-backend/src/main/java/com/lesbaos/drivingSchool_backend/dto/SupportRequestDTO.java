package com.lesbaos.drivingSchool_backend.dto;

import com.lesbaos.drivingSchool_backend.enumerations.TypeSupport;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupportRequestDTO {
    @NotBlank
    private String name;

    @NotNull
    private Long administratorId;

    @NotBlank
    private TypeSupport typeSupport;

}
