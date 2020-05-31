package com.customer.txn.repository;

import com.customer.txn.entity.Txn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TxnRepository extends JpaRepository<Txn, Long> {

    List<Txn> findByCustomerId(Long customerId);

    List<Txn> findByDescription(String description);

    @Query(value = "SELECT t" +
                "     FROM Txn t" +
                "    WHERE t.accountNumber in :accountNumbers")
    List<Txn> findByAccountNumbers(@Param("accountNumbers") List<String> accountNumbers);
}
