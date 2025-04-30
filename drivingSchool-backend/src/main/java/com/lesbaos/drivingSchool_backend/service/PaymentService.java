package com.lesbaos.drivingSchool_backend.service;

import com.lesbaos.drivingSchool_backend.data.Payment;
import com.lesbaos.drivingSchool_backend.dto.PaymentRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.PaymentResponseDTO;

import java.util.List;

public interface PaymentService {

    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO);
    public PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO paymentRequestDTO);
    public Payment findPaymentById(Long id);
    public PaymentResponseDTO getPaymentById(Long id);
    public void deletePayment(Long id);
    public List<PaymentResponseDTO> findAllPayments();
}
