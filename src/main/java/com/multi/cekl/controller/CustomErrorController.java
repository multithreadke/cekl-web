package com.multi.cekl.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {
	
	 private static Logger log = LoggerFactory.getLogger(ErrorController.class);

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseEntity< Map<String, String>> errorFallBack(HttpServletRequest request)
    {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        String error = "";
        String code = "";
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                code = "404";
                error = "provided url - not found";
                log.error(error);
            }
            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                code = "500";
                error = "action cannot be completed - internal service error";
                log.error(error);
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("statusCode", code);
        map.put("message", error);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
