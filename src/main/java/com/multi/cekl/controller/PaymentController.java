package com.multi.cekl.controller;

import com.multi.cekl.dto.PaymentDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.CustomerService;
import com.multi.cekl.service.PaymentModeService;
import com.multi.cekl.service.PaymentService;
import com.multi.cekl.utils.ResponseMessage;
import com.multi.cekl.validation.ValidationErrorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentModeService paymentModeService;

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public ResponseEntity<?> getPayment(@PageableDefault(size = 40) Pageable pageable) {
        return new ResponseEntity<>(paymentService.getPaymentList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getPayment(@PathVariable("id") String id) {
        return new ResponseEntity<>(paymentService.getPayment(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public ResponseEntity<?> addPayment(@Valid @RequestBody PaymentDTO payment, Errors error) {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        } else if (!customerService.exists(payment.getCustomer())) {
            return new ResponseEntity<>(new CustomResponse("404", "customer record with id " + payment.getCustomer() + " not found!"), HttpStatus.OK);
        } else if (!paymentModeService.exists(payment.getPaymentMode())) {
            return new ResponseEntity<>(new CustomResponse("404", "payment mode record with id " + payment.getPaymentMode() + " not found!"), HttpStatus.OK);
        } else
            return new ResponseEntity<>(paymentService.create(payment), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updatePayment(@Valid @RequestBody PaymentDTO payment, Errors error, @PathVariable("id") String id) {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        } else if (!customerService.exists(payment.getCustomer())) {
            return new ResponseEntity<>(new CustomResponse("404", "customer record with id " + payment.getCustomer() + " not found!"), HttpStatus.OK);
        } else if (!paymentModeService.exists(payment.getPaymentMode())) {
            return new ResponseEntity<>(new CustomResponse("404", "payment mode record with id " + payment.getPaymentMode() + " not found!"), HttpStatus.OK);
        } else if (paymentService.exists(id)) {
            return new ResponseEntity<>(paymentService.update(id, payment), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletePayment(@PathVariable("id") String id) {
        if (paymentService.exists(id)) {
            if (paymentService.remove(id)) {
                return new ResponseEntity<>(ResponseMessage.success, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ResponseMessage.failed, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }


}
