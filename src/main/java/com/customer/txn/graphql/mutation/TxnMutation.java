package com.customer.txn.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.customer.txn.entity.Txn;
import com.customer.txn.service.TxnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TxnMutation implements GraphQLMutationResolver {

    @Autowired
    private TxnService txnService;

    public Txn createTxn(final String accountNumber,
                         final String txnAmount,
                         final String description,
                         final String txnDate,
                         final String txnTime,
                         final Long customerId) {

        return txnService.createTxn(accountNumber, txnAmount, description, getTxnDate(txnDate), txnTime, customerId);
    }

    public Date getTxnDate(String txnDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(txnDate);
        } catch (ParseException e) {
            return null;
        }
    }
}
