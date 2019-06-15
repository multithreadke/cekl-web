package com.multi.cekl.controller;

import com.multi.cekl.dto.PackingDTO;
import com.multi.cekl.response.CustomResponse;
import com.multi.cekl.service.PackingService;
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
public class PackingController {

    @Autowired
    private PackingService packingService;

    @RequestMapping(value = "/unit", method = RequestMethod.GET)
    public ResponseEntity<?> getUnit(@PageableDefault(size = 40) Pageable pageable)
    {
        return new ResponseEntity<>(packingService.getPackingList(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/unit/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUnit(@PathVariable("id") String id)
    {
        if(packingService.exists(id)){
        return new ResponseEntity<>(packingService.getPackingById(id), HttpStatus.OK);
    }else {
        return new ResponseEntity<>(ResponseMessage.notfound, HttpStatus.OK);
    }
    }

    @RequestMapping(value = "/unit", method = RequestMethod.POST)
    public ResponseEntity<?> addUnit(@Valid @RequestBody PackingDTO packing, Errors error)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(packingService.create(packing), HttpStatus.OK);
    }

    @RequestMapping(value = "/unit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> deleteUnit(@Valid @RequestBody PackingDTO packing, Errors error, @PathVariable("id") String id)
    {
        if (error.hasErrors()) {
            return new ResponseEntity<>(new CustomResponse("400", ValidationErrorBuilder.fromBindingErrors(error).toString()), HttpStatus.OK);
        }
        return new ResponseEntity<>(packingService.update(id, packing), HttpStatus.OK);
    }

    @RequestMapping(value = "/unit/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUnit(@PathVariable("id") String id)
    {
        if(packingService.exists(id))
        {
            if(packingService.remove(id))
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
