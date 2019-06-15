package com.multi.cekl.service;


import com.multi.cekl.dto.PaymentModeDTO;
import com.multi.cekl.model.PaymentMode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PaymentModeService {
    PaymentMode create(PaymentModeDTO paymentMode);
    PaymentMode update(String id, PaymentModeDTO paymentMode);
    Boolean remove(String id);
    Boolean exists(String id);
    PaymentMode getPaymentMode(String id);
    Page<PaymentMode> getPaymentList(Pageable pageable);
}
