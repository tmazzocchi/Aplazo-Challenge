package com.mazzocchitomas.simpleinterestmicroservice.usecase;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;
import com.mazzocchitomas.simpleinterestmicroservice.model.entity.Request;
import com.mazzocchitomas.simpleinterestmicroservice.model.entity.Response;
import com.mazzocchitomas.simpleinterestmicroservice.repository.RequestRepository;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.CreatePayments;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.impl.CreatePaymentsImpl;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.repository.impl.SaveToRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SaveToRepositoryTest {
    Double amount = 500.00;
    Double rate = 10.00;
    Integer terms = 5;
    LocalDate today = LocalDate.now();
    CreatePayments createPayments = new CreatePaymentsImpl();

    @Test
    void applyOK() {
        var requestEntity = mock(Request.class);
        var repository = mock(RequestRepository.class);
        var saveToRespository = new SaveToRepositoryImpl(repository);
        when(repository.save(requestEntity)).thenReturn(requestEntity);

        var request = GeneratePaymentsRequest.builder()
                .amount(amount)
                .rate(rate)
                .terms(terms)
                .build();
        var response = createPayments.apply(550.00, 5, today);

        saveToRespository.apply(request, response);
        verify(repository, atLeastOnce()).save(any());
    }
}
