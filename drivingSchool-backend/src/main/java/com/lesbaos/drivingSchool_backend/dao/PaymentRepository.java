package com.lesbaos.drivingSchool_backend.dao;

import com.lesbaos.drivingSchool_backend.data.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
