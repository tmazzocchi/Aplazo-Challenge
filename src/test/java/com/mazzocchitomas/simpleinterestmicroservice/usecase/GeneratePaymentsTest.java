package com.mazzocchitomas.simpleinterestmicroservice.usecase;

import com.mazzocchitomas.simpleinterestmicroservice.exception.ValidatorException;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.entity.Request;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.CreatePayments;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.GeneratePayments;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.impl.CreatePaymentsImpl;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.impl.GeneratePaymentsImpl;
import com.mazzocchitomas.simpleinterestmicroservice.util.DateUtil;
import com.mazzocchitomas.simpleinterestmicroservice.validation.AnnotationBasedValidator;
import com.mazzocchitomas.simpleinterestmicroservice.validation.DefaultAnnotationBasedValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GeneratePaymentsTest {
    Double amount = 500.00;
    Double rate = 10.00;
    Integer terms = 5;
    LocalDate today = LocalDate.now();
    AnnotationBasedValidator annotationBasedValidator =
            new DefaultAnnotationBasedValidator();

    @Test
    void applyOk() {
        CreatePayments createPayments = new CreatePaymentsImpl();
        var request = GeneratePaymentsRequest.builder()
                .amount(amount)
                .rate(rate)
                .terms(terms)
                .build();
        GeneratePayments generatePayments = new GeneratePaymentsImpl(annotationBasedValidator, createPayments);
        var response = generatePayments.apply(request);
        //AMOUNT ASSERTS
        assertEquals(110.0, response.get(0).getAmount());
        assertEquals(110.0, response.get(1).getAmount());
        assertEquals(110.0, response.get(2).getAmount());
        assertEquals(110.0, response.get(3).getAmount());
        assertEquals(110.0, response.get(4).getAmount());
        //PAYMENT_NUMBER ASSERTS
        assertEquals(1, response.get(0).getPaymentNumber());
        assertEquals(2, response.get(1).getPaymentNumber());
        assertEquals(3, response.get(2).getPaymentNumber());
        assertEquals(4, response.get(3).getPaymentNumber());
        assertEquals(5, response.get(4).getPaymentNumber());
        //PAYMENT_DATE ASSERTS
        assertEquals(today, response.get(0).getPaymentDate());
        assertEquals(today.plusWeeks(1), response.get(1).getPaymentDate());
        assertEquals(today.plusWeeks(2), response.get(2).getPaymentDate());
        assertEquals(today.plusWeeks(3), response.get(3).getPaymentDate());
        assertEquals(today.plusWeeks(4), response.get(4).getPaymentDate());
        //TERMS SIZE
        assertEquals(terms, response.size());
    }

    @Test
    void whenInputAreLowerThanMin_ValidationExceptionExpected() {
        var amount = 0.9;
        var rate = 0.5;
        var terms = 1;
        CreatePayments createPayments = new CreatePaymentsImpl();
        var request = GeneratePaymentsRequest.builder()
                .amount(amount)
                .rate(rate)
                .terms(terms)
                .build();
        GeneratePayments generatePayments = new GeneratePaymentsImpl(annotationBasedValidator, createPayments);

        final Executable executable = () ->generatePayments.apply(request);
        assertThrows(
                ValidatorException.class,
                executable,
                "Passing a lower inputs must throw a ValidatorException."
        );
    }

    @Test
    void whenInputAreBiggerThanMax_ValidationExceptionExpected() {
        var amount = 10000000.0;
        var rate = 1111.0;
        var terms = 70;
        CreatePayments createPayments = new CreatePaymentsImpl();
        var request = GeneratePaymentsRequest.builder()
                .amount(amount)
                .rate(rate)
                .terms(terms)
                .build();
        GeneratePayments generatePayments = new GeneratePaymentsImpl(annotationBasedValidator, createPayments);

        final Executable executable = () ->generatePayments.apply(request);
        assertThrows(
                ValidatorException.class,
                executable,
                "Passing a lower inputs must throw a ValidatorException."
        );
    }
}
