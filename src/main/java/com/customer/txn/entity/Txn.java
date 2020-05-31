package com.customer.txn.entity;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Txn", schema = "public")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Txn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "accountNumber", nullable = false)
    String accountNumber;

    @Column(name = "txnAmount", nullable = false)
    BigDecimal txnAmount;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "txnDate", nullable = false)
    @Type(type = "date")
    Date txnDate;

    @Column(name = "txnTime", nullable = false)
    String txnTime;

    @Column(name = "customerId", nullable = false)
    Long customerId;

}
