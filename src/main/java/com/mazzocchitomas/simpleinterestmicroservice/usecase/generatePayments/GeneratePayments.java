package com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;

import java.util.List;

@FunctionalInterface
public interface GeneratePayments {
    List<GeneratePaymentsResponse> apply(GeneratePaymentsRequest request);
}
