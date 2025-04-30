package com.lesbaos.drivingSchool_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRequestDTO {
    @NotNull
    private Long amount;

   @NotBlank
    private String paymentMethod;

   @NotNull
    private Long administratorId;
}
