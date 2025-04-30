package com.lesbaos.drivingSchool_backend.controller;

import com.lesbaos.drivingSchool_backend.data.Payment;
import com.lesbaos.drivingSchool_backend.dto.InstructorResponseDTO;
import com.lesbaos.drivingSchool_backend.dto.PaymentRequestDTO;
import com.lesbaos.drivingSchool_backend.dto.PaymentResponseDTO;
import com.lesbaos.drivingSchool_backend.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/createPayment")
    public ResponseEntity<PaymentResponseDTO> createPayment(@RequestBody PaymentRequestDTO PaymentRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.createPayment(PaymentRequestDTO));
    }

    @PutMapping("/updatePayment/{id}")
    public ResponseEntity<PaymentResponseDTO> updatePayment(@PathVariable Long id, @RequestBody PaymentRequestDTO PaymentRequestDTO) {
        return ResponseEntity.ok(paymentService.updatePayment(id, PaymentRequestDTO));
    }

    @GetMapping("/findPaymentById/{id}")
    public ResponseEntity<PaymentResponseDTO> findPaymentById(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.getPaymentById(id));
    }

    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAllPayments")
    public ResponseEntity<List<PaymentResponseDTO>> findAllPayments() {
        return ResponseEntity.ok(paymentService.findAllPayments());
    }
}
