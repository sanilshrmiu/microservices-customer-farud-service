package com.ms.service;

import com.ms.model.FraudCheckHistory;
import com.ms.repo.FraudCheckHistoryRepo;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public record FraudCheckHistoryService(FraudCheckHistoryRepo fraudCheckHistoryRepo) {

    public boolean isFraudCustomer(Long customerId) {
        fraudCheckHistoryRepo.save(FraudCheckHistory.builder()
                .isFraud(false)
                .customerId(customerId)
                .createdAt(new Date())
                .build());
        return false;
    }

}
