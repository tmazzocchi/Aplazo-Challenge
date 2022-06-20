package com.mazzocchitomas.simpleinterestmicroservice.usecase.repository;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;

import java.util.List;

@FunctionalInterface
public interface SaveToRepository {
    void apply(GeneratePaymentsRequest request, List<GeneratePaymentsResponse> response);
}
