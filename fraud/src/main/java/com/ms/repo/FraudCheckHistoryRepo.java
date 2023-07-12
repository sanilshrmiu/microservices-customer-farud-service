package com.ms.repo;

import com.ms.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepo extends JpaRepository<FraudCheckHistory, Long> {
}
