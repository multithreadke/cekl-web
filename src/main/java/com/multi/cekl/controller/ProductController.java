package com.multi.cekl.controller;

import com.multi.cekl.dto.ProductDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.CategoryService;
import com.multi.cekl.service.PackingService;
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
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PackingService packingService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PageableDefault(size = 40) Pageable pageable)
    {
        return new ResponseEntity<>(productService.getProductList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable("id") String id)
    {
        if(productService.exists(id)){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDTO productDTO, Errors error)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }

        if(!packingService.exists(productDTO.getUnit()))
        {
            return new ResponseEntity<>(new CustomResponse("404","unit record with id "+productDTO.getUnit()+" not found!"), HttpStatus.OK);
        }

        if(!categoryService.exists(productDTO.getCategory()))
        {
            return new ResponseEntity<>(new CustomResponse("404", "category record with id "+productDTO.getCategory()+" not found!"), HttpStatus.OK);
        }
        return new ResponseEntity<>(productService.create(productDTO), HttpStatus.OK);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteProduct(@Valid @RequestBody ProductDTO productDTO, Errors error, @PathVariable("id") String id)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        if(!packingService.exists(productDTO.getUnit()))
        {
            return new ResponseEntity<>(new CustomResponse("404","unit record with id "+productDTO.getUnit()+" not found!"), HttpStatus.OK);
        }

        if(!categoryService.exists(productDTO.getCategory()))
        {
            return new ResponseEntity<>(new CustomResponse("404", "category record with id "+productDTO.getCategory()+" not found!"), HttpStatus.OK);
        }

        if(productService.exists(id)){
        return new ResponseEntity<>(productService.update(id, productDTO), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") String id)
    {
        if(productService.exists(id))
        {
            if(productService.remove(id))
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
