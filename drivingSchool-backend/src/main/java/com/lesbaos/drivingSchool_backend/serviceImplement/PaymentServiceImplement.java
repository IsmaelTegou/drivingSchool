package com.lesbaos.drivingSchool_backend.serviceImplement;

import com.lesbaos.drivingSchool_backend.dao.PaymentRepository;
import com.lesbaos.drivingSchool_backend.data.Payment;
import com.lesbaos.drivingSchool_backend.dto.PaymentRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.PaymentResponseDTO;
import com.lesbaos.drivingSchool_backend.service.AdministratorService;
import com.lesbaos.drivingSchool_backend.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImplement implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final AdministratorService administratorService;

    public PaymentServiceImplement(PaymentRepository paymentRepository, AdministratorService administratorService) {
        this.paymentRepository = paymentRepository;
        this.administratorService = administratorService;
    }

    @Override
    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Payment payment = Payment.builder()
                .paymentDate(LocalDateTime.now())
                .amount(paymentRequestDTO.getAmount())
                .paymentMethod(paymentRequestDTO.getPaymentMethod())
                .administrator(administratorService.findAdministratorById(paymentRequestDTO.getAdministratorId()))
                .build();
        paymentRepository.save(payment);
        return mapToPaymentResponseDTO(payment);
    }

    @Override
    public PaymentResponseDTO updatePayment(Long id, PaymentRequestDTO paymentRequestDTO) {
        Payment payment = findPaymentById(id);
        payment.setAmount(paymentRequestDTO.getAmount());
        payment.setPaymentMethod(paymentRequestDTO.getPaymentMethod());
        payment.setAdministrator(administratorService.findAdministratorById(paymentRequestDTO.getAdministratorId()));
        paymentRepository.save(payment);
        return mapToPaymentResponseDTO(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Payment with id %s not found", id))
        );
    }

    @Override
    public PaymentResponseDTO getPaymentById(Long id) {
        return mapToPaymentResponseDTO(findPaymentById(id));
    }

    @Override
    public void deletePayment(Long id) {
        Payment payment = findPaymentById(id);
        paymentRepository.delete(payment);
    }

    @Override
    public List<PaymentResponseDTO> findAllPayments() {
        return paymentRepository.findAll().stream().map(this::mapToPaymentResponseDTO).toList();
    }

    private PaymentResponseDTO mapToPaymentResponseDTO(Payment payment) {
        return PaymentResponseDTO.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .lastnameAdmin(payment.getAdministrator().getLastName())
                .build();
    }
}
