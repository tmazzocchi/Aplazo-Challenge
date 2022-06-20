package com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.impl;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.CreatePayments;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.GeneratePayments;
import com.mazzocchitomas.simpleinterestmicroservice.util.DateUtil;
import com.mazzocchitomas.simpleinterestmicroservice.util.MathUtil;
import com.mazzocchitomas.simpleinterestmicroservice.validation.AnnotationBasedValidator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class GeneratePaymentsImpl implements GeneratePayments {

    private final AnnotationBasedValidator annotationBasedValidator;
    private final CreatePayments createPayments;

    @Override
    public List<GeneratePaymentsResponse> apply(GeneratePaymentsRequest request) {
        annotationBasedValidator.accept(request);

        var terms = request.getTerms();
        var amount = request.getAmount();
        var rate = request.getRate();

        log.info("Calculating amount per week...");
        var amountByTerm = MathUtil.getAmountPerWeek(amount, rate, terms);
        log.info("Amount per week is: {}", amountByTerm);

        log.info("Generating list of payments...");
        var today = DateUtil.getDate();
        var paymentsList = createPayments.apply(amountByTerm, terms, today);
        log.info("List of payments generated, finishing ... :D");

        return paymentsList;
    }
}
