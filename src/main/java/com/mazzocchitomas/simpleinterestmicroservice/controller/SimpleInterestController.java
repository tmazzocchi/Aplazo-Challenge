package com.mazzocchitomas.simpleinterestmicroservice.controller;

import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsRequest;
import com.mazzocchitomas.simpleinterestmicroservice.model.controller.GeneratePaymentsResponse;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.generatePayments.GeneratePayments;
import com.mazzocchitomas.simpleinterestmicroservice.usecase.repository.SaveToRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/listOfPayments")
public class SimpleInterestController {

    private final GeneratePayments generatePayments;
    private final SaveToRepository saveToRepository;

    @Operation(description = "Generates the list of payments of the simple interest of a credit that must be paid in 'n' terms")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GeneratePaymentsResponse>> generatePayments(@RequestBody GeneratePaymentsRequest request) {

        var response = generatePayments.apply(request);

        log.info("Saving request & response...");
        saveToRepository.apply(request, response);
        log.info("Request & response saved.");

        log.info("Bye!");
        return ResponseEntity.ok(response);
    }
}