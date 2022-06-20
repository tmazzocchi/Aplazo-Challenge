package com.mazzocchitomas.simpleinterestmicroservice.model.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GeneratePaymentsResponse {

    @JsonProperty(value = "payment_number")
    private Integer paymentNumber;
    private Double amount;
    @JsonProperty(value = "payment_date")
    private LocalDate paymentDate;
}

