package com.controllers;

import com.model.PaymentList;
import com.model.Result;
import com.service.calcualtion.Calculation;
import com.service.text.StringTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Viktor Makarov
 */
@RestController
public class MainController {
    StringTransformer stringTransformer;
    Calculation calculation;

    MainController(@Autowired StringTransformer stringTransformer, @Autowired Calculation calculation) {
        this.stringTransformer = stringTransformer;
        this.calculation = calculation;
    }

    @PostMapping(value = "/string", produces = MediaType.TEXT_PLAIN_VALUE)
    public String helloPage(@RequestBody String s) {
        return stringTransformer.returnTransformedStringsAsSingleString(s);
    }

    @PostMapping(value = "/getResult", produces = MediaType.APPLICATION_XML_VALUE)
    public Result testPage(@RequestParam(required = false, defaultValue = "9999-01-01") String date,
                           @RequestParam(required = false, defaultValue = "false") boolean tax,
                           @RequestBody(required = false) PaymentList paymentList) {
        return calculation.calculateResult(paymentList, tax, date);
    }
}
