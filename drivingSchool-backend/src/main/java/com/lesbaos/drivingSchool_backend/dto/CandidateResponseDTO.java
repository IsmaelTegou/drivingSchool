package com.lesbaos.drivingSchool_backend.dto;

import com.lesbaos.drivingSchool_backend.enumerations.TypeCandidate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CandidateResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private TypeCandidate typeCandidate;
    private String password;
}
