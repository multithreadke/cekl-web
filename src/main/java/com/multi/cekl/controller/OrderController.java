package com.multi.cekl.controller;

import com.multi.cekl.dto.OrderDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.CustomerService;
import com.multi.cekl.service.OrderService;
import com.multi.cekl.service.ProductService;
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
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public ResponseEntity<?> getOrder(@PageableDefault(size = 40) Pageable pageable)
    {
        return new ResponseEntity<>(orderService.getOrderList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getOrderById(@PathVariable("id") String id)
    {
        if(orderService.exists(id)){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderDTO order, Errors error)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }else if(!customerService.exists(order.getCustomer()))
        {
            return new ResponseEntity<>(new CustomResponse("404","customer record with id "+order.getCustomer()+" not found!"), HttpStatus.OK);
        }else if(!productService.exists(order.getProduct()))
        {
            return new ResponseEntity<>(new CustomResponse("404","product record with id "+order.getProduct()+" not found!"), HttpStatus.OK);
        } else
        return new ResponseEntity<>(orderService.create(order), HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteOrder(@Valid @RequestBody OrderDTO order, Errors error, @PathVariable("id") String id)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }else if(!customerService.exists(order.getCustomer()))
        {
            return new ResponseEntity<>(new CustomResponse("404","customer record with id "+order.getCustomer()+" not found!"), HttpStatus.OK);
        }else if(!productService.exists(order.getProduct()))
        {
            return new ResponseEntity<>(new CustomResponse("404","product record with id "+order.getProduct()+" not found!"), HttpStatus.OK);
        } else if(orderService.exists(id)){
        return new ResponseEntity<>(orderService.update(id, order), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteorder(@PathVariable("id") String id)
    {
        if(orderService.exists(id))
        {
            if(orderService.remove(id))
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
