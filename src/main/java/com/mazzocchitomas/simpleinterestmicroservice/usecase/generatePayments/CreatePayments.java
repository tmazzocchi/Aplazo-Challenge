package com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;

import java.time.LocalDate;
import java.util.List;

@FunctionalInterface
public interface CreatePayments {
    List<GeneratePaymentsResponse> apply(Double amount, Integer terms, LocalDate date);
}
