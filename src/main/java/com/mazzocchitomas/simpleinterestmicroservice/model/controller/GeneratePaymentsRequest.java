package com.mazzocchitomas.simpleinterestmicroservice.model.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class GeneratePaymentsRequest {

    private static final String AMOUNT_TERMS_NOT_BLANK = "Amount field must not be null.";
    private static final String TERMS_NOT_BLANK = "Terms field must not be null.";
    private static final String RATE_NOT_BLANK = "Rate field must not be null.";
    private static final String AMOUNT_TERMS_INVALID = "The amount should be more than $1.00, the max should be lesser than $999,999.00.";
    private static final String TERMS_INVALID = "The max terms (weeks) were the payment can be paid is 52, the minimum should be 4.";
    private static final String RATE_TERMS_INVALID = "The rate should bigger than 1%, lesser than 100%.";

    @NotNull(message = AMOUNT_TERMS_NOT_BLANK)
    @Min(value = 1, message = AMOUNT_TERMS_INVALID)
    @Max(value = 999999, message = AMOUNT_TERMS_INVALID)
    private Double amount;

    @NotNull(message = TERMS_NOT_BLANK)
    @Max(value = 52, message = TERMS_INVALID)
    @Min(value = 4, message = TERMS_INVALID)
    private Integer terms;

    @NotNull(message = RATE_NOT_BLANK)
    @Min(value = 1, message = RATE_TERMS_INVALID)
    @Max(value = 100, message = RATE_TERMS_INVALID)
    private Double rate;
}
