package com.mazzocchitomas.simpleinterestmicroservice.usecase;

import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.CreatePayments;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.impl.CreatePaymentsImpl;
import com.mazzocchitomas.simpleinterestmicroservice.util.MathUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CreatePaymentsTest {

    Double amount = 500.00;
    Double rate = 10.00;
    Integer terms = 1;
    LocalDate today = LocalDate.now();
    CreatePayments createPayments = new CreatePaymentsImpl();

    @Test
    void applyOK(){
        var totalAmount = MathUtil.getAmountPerWeek(amount, rate, terms);
        var paymentsResponse = createPayments.apply(totalAmount, terms, today);

        assertEquals(1, paymentsResponse.size());
        assertEquals(550.00, paymentsResponse.get(0).getAmount());
        assertEquals(today, paymentsResponse.get(0).getPaymentDate());
        assertEquals(1, paymentsResponse.get(0).getPaymentNumber());
    }

    @Test
    void whenTermsIsNull_NullPointerExpected() {
        final Executable executable = () -> createPayments.apply(amount, null, today);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }

    @Test
    void whenTodayIsNull_NullPointerExpected() {
        final Executable executable = () -> createPayments.apply(amount, terms, null);
        assertThrows(
                NullPointerException.class,
                executable,
                "Passing a null argument must throw a NullPointerException."
        );
    }
}
