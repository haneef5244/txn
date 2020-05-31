package com.customer.txn.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.customer.txn.entity.Txn;
import com.customer.txn.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TxnQuery implements GraphQLQueryResolver {

    @Autowired
    private TxnService txnService;

    public List<Txn> getTxns(final int count) {
        return this.txnService.getAllTxns(count);
    }

    /** Get By ID */
    public Optional<Txn> getTxn(final Long id) {
        return txnService.getTxn(id);
    }

    /** Get By Customer ID */
    public List<Txn> getTxnByCustomerId(final Integer first, final Integer after, final Long customerId) {
        // Limit and offset is optional
        if (first == null || after == null) {
            return txnService.getTxnByCustomerId(customerId);
        }
        return txnService.getTxnByCustomerId(first, after, customerId);
    }

    /** Get By Description */
    public List<Txn> getTxnByDescription(final Integer first, final Integer after, final String description) {
        // Limit and offset is optional
        if (first == null || after == null) {
            return txnService.getTxnByDescription(description);
        }
        return txnService.getTxnByDescription(first, after, description);
    }

    /** Get By Account Number(s) */
    public List<Txn> getTxnByAccountNumbers(final Integer first, final Integer after, final List<String> accountNumbers) {
        // Limit and offset is optional
        if (first == null || after == null) {
            return txnService.getTxnByAccountNumbers(accountNumbers);
        }
        return txnService.getTxnByAccountNumbers(first, after, accountNumbers);
    }

}
