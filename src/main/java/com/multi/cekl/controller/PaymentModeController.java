package com.multi.cekl.controller;

import com.multi.cekl.dto.PaymentModeDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.PaymentModeService;
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
public class PaymentModeController {

    @Autowired
    private PaymentModeService paymentModeService;

    @RequestMapping(value = "/payment/mode", method = RequestMethod.GET)
    public ResponseEntity<?> getMode(@PageableDefault(size = 40) Pageable pageable)
    {
        return new ResponseEntity<>(paymentModeService.getPaymentList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/mode/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMode(@PathVariable("id") String id)
    {
        if(paymentModeService.exists(id)){
        return new ResponseEntity<>(paymentModeService.getPaymentMode(id), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/payment/mode", method = RequestMethod.POST)
    public ResponseEntity<?> addMode(@Valid @RequestBody PaymentModeDTO paymentMode, Errors error)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(paymentModeService.create(paymentMode), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/mode/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteMode(@Valid @RequestBody PaymentModeDTO paymentModeDTO, Errors error, @PathVariable("id") String id)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(paymentModeService.update(id, paymentModeDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/payment/mode/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteMode(@PathVariable("id") String id)
    {
        if(paymentModeService.exists(id))
        {
            if(paymentModeService.remove(id))
            {
                return new ResponseEntity<>(ResponseMessage.success, HttpStatus.OK);
            }else
            {
                return new ResponseEntity<>(ResponseMessage.failed, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }
}
