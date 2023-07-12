package com.ms.controller;

import com.ms.dto.FraudCheckResponse;
import com.ms.service.FraudCheckHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/fraud-check")
public record FraudController(FraudCheckHistoryService service) {

    @GetMapping("{customerId}")
    public FraudCheckResponse isFraud(@PathVariable("customerId") Long customerId) {
        log.info("fraud check request for customer {}", customerId);
        return new FraudCheckResponse(service.isFraudCustomer(customerId));
    }

}
