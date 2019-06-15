package com.multi.cekl.service;

import com.multi.cekl.dto.PaymentModeDTO;
import com.multi.cekl.model.PaymentMode;
import com.multi.cekl.repository.PaymentModeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentModeServiceImpl implements PaymentModeService {

    @Autowired
    private PaymentModeRepository repository;

    @Override
    public PaymentMode create(PaymentModeDTO paymentMode) {
        return repository.save(new PaymentMode(paymentMode.getName(), paymentMode.getDescription()));
    }

    @Override
    public PaymentMode update(String id, PaymentModeDTO paymentMode) {
        PaymentMode mode = repository.findByIdIgnoreCase(id);
        mode.setId(id);
        mode.setName(paymentMode.getName());
        mode.setDescription(paymentMode.getDescription());
        return repository.save(mode);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(exists(id))
        {
            repository.delete(getPaymentMode(id));
            success = true;
        }else{
            success = false;
        }
        return success;
    }

    @Override
    public Boolean exists(String id) {
        return repository.existsByIdIgnoreCase(id);
    }

    @Override
    public PaymentMode getPaymentMode(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<PaymentMode> getPaymentList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
