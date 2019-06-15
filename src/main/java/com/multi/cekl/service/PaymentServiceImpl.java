package com.multi.cekl.service;

import com.multi.cekl.dto.PaymentDTO;
import com.multi.cekl.model.Payment;
import com.multi.cekl.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentModeService paymentModeService;

    @Override
    public Payment create(PaymentDTO payment) {
        return repository.save(new Payment(customerService.getCustomerById(payment.getCustomer()), payment.getTotalQty(), payment.getTotalPrice(), payment.getSession(), paymentModeService.getPaymentMode(payment.getPaymentMode()), new Date()));
    }

    @Override
    public Payment update(String id, PaymentDTO payment) {
        Payment pay = repository.findByIdIgnoreCase(id);
        pay.setId(id);
        pay.setCustomer(customerService.getCustomerById(payment.getCustomer()));
        pay.setPaymentMode(paymentModeService.getPaymentMode(payment.getPaymentMode()));
        pay.setSessionId(payment.getSession());
        pay.setTotalQty(payment.getTotalQty());
        pay.setTotalPrice(payment.getTotalPrice());
        pay.setDateCreated(new Date());
        return repository.save(pay);
    }

    @Override
    public Boolean remove(String id) {
        boolean success;
        if(exists(id))
        {
            repository.delete(getPayment(id));
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
    public Payment getPayment(String id) {
        return repository.findByIdIgnoreCase(id);
    }

    @Override
    public Page<Payment> getPaymentList(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
