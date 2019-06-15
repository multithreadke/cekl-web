package com.multi.cekl.controller;

import com.multi.cekl.dto.AddressDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.AddressService;
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
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public ResponseEntity<?> getAddress(@PageableDefault(size = 40) Pageable pageable) {
        return new ResponseEntity<>(addressService.getAddressList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getAddressById(@PathVariable("id") String id) {
        if (addressService.exists(id)) {
            return new ResponseEntity<>(addressService.getAddressById(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ResponseEntity<?> addAddress(@Valid @RequestBody AddressDTO address, Errors error) {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }

        if (!customerService.exists(address.getCustomer())) {
            return new ResponseEntity<>(new CustomResponse("404","customer record with id " +address.getCustomer()+ " not found!"), HttpStatus.OK);
        }
        return new ResponseEntity<>(addressService.create(address), HttpStatus.OK);
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteAddress(@RequestBody AddressDTO address, @PathVariable("id") String id) {
        if (addressService.exists(id)) {
            return new ResponseEntity<>(addressService.update(id, address), HttpStatus.OK);
        } else if (!customerService.exists(address.getCustomer())) {
            return new ResponseEntity<>(new CustomResponse("404","customer record with id " +address.getCustomer()+ " not found!"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAddress(@PathVariable("id") String id) {
        if (addressService.exists(id)) {
            if (addressService.remove(id)) {
                return new ResponseEntity<>(ResponseMessage.success, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(ResponseMessage.failed, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }
}
