package com.lesbaos.drivingSchool_backend.dto;

import com.lesbaos.drivingSchool_backend.enumerations.TypeSupport;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupportResponseDTO {
    private Long id;
    private String name;
    private TypeSupport typeSupport;
    private String lastnameAdmin;
}
