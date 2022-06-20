package com.mazzocchitomas.simpleinterestmicroservice.usecase.repository.impl;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;
import com.mazzocchitomas.simpleinterestmicroservice.model.entity.Request;
import com.mazzocchitomas.simpleinterestmicroservice.model.entity.Response;
import com.mazzocchitomas.simpleinterestmicroservice.repository.RequestRepository;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.repository.SaveToRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class SaveToRepositoryImpl implements SaveToRepository {
    private final RequestRepository requestRepository;

    @Override
    public void apply(GeneratePaymentsRequest request, List<GeneratePaymentsResponse> response) {
        var requestEntity = Request.builder()
                .amount(request.getAmount())
                .rate(request.getRate())
                .terms(request.getTerms())
                .build();
        var responseEntities = new ArrayList<Response>();
        response.stream().forEach(x -> {
            var responseEntity = Response.builder()
                    .paymentNumber(x.getPaymentNumber())
                    .amount(x.getAmount())
                    .paymentDate(x.getPaymentDate())
                    .request(requestEntity)
                    .build();
            responseEntities.add(responseEntity);
        });
        requestEntity.setResponseList(responseEntities);
        try {
            requestRepository.save(requestEntity);
        } catch (IllegalArgumentException e) {
            log.error("There was an error trying to save request & response");
        }
    }
}
