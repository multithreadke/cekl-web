package com.multi.cekl.repository;

import com.multi.cekl.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository  extends JpaRepository<Payment, String> {
    Payment findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
