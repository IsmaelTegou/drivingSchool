package com.lesbaos.drivingSchool_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentResponseDTO {
    private Long id;
    private String paymentMethod;
    private Double amount;
    private String lastnameAdmin;
}
