package com.multi.cekl.service;


import com.multi.cekl.dto.PaymentDTO;
import com.multi.cekl.model.Payment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentService {

    Payment create(PaymentDTO payment);
    Payment update(String id, PaymentDTO payment);
    Boolean remove(String id);
    Boolean exists(String id);
    Payment getPayment(String id);
    Page<Payment> getPaymentList(Pageable pageable);

}
