package com.ms.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {

    @Id
    @SequenceGenerator(sequenceName = "FRAUD_CHECK_HISTORY_SEQ", name = "FRAUD_CHECK_HISTORY_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FRAUD_CHECK_HISTORY_SEQ")
    private Long id;
    private Long customerId;
    private Boolean isFraud;
    private Date createdAt;

}
