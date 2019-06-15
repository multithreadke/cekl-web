package com.multi.cekl.controller;

import com.multi.cekl.dto.CustomerDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.CustomerService;
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
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomer(@PageableDefault(size = 40) Pageable pageable)
    {
        return new ResponseEntity<>(customerService.getCustomerList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerById(@PathVariable("id") String id)
    {
        if(customerService.exists(id)){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDTO customer, Errors error)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerService.create(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteCustomer(@Valid @RequestBody CustomerDTO customer, Errors error, @PathVariable("id") String id)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        if(customerService.exists(id)){
        return new ResponseEntity<>(customerService.update(id, customer), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") String id)
    {
        if(customerService.exists(id))
        {
            if(customerService.remove(id))
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
