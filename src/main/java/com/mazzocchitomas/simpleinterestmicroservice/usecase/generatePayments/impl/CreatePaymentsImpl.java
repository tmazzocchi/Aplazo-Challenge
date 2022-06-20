package com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.impl;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.CreatePayments;
import com.mazzocchitomas.simpleinterestmicroservice.util.DateUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreatePaymentsImpl implements CreatePayments {
    @Override
    public List<GeneratePaymentsResponse> apply(Double amount, Integer terms, LocalDate todayDate) {
        var paymentsList = new ArrayList<GeneratePaymentsResponse>();
        for (int i = 0; i < terms; i++) {
            var paymentDate = DateUtil.getDatePlusWeek(todayDate, i);
            var payment = GeneratePaymentsResponse.builder()
                    .paymentNumber(i + 1)
                    .amount(amount)
                    .paymentDate(paymentDate)
                    .build();
            paymentsList.add(payment);
        }
        return paymentsList;
    }
}
