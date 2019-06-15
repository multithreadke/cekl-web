package com.multi.cekl.repository;

import com.multi.cekl.model.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentModeRepository extends JpaRepository<PaymentMode, String> {
    PaymentMode findByIdIgnoreCase(String id);
    Boolean existsByIdIgnoreCase(String id);
}
