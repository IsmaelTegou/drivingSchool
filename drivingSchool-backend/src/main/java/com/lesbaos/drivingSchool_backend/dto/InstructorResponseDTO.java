package com.lesbaos.drivingSchool_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InstructorResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
}
