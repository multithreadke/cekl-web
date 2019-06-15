package com.multi.cekl.controller;

import com.multi.cekl.dto.CategoryDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.CategoryService;
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
public class CategoryController {

    @Autowired
    private CategoryService  categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<?> getCategory(@PageableDefault(size = 40) Pageable pageable)
    {
        return new ResponseEntity<>(categoryService.getCategoryList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryById(@PathVariable("id") String id)
    {
        if(categoryService.exists(id)){
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDTO category, Errors error)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteCategory(@Valid @RequestBody CategoryDTO address, Errors error, @PathVariable("id") String id)
    {
        if (error.hasErrors()) {
        return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
    }
        if(categoryService.exists(id)){
        return new ResponseEntity<>(categoryService.update(id, address), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCategory(@PathVariable("id") String id)
    {
        if(categoryService.exists(id))
        {
            if(categoryService.remove(id))
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
