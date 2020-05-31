package com.customer.txn.service;

import com.customer.txn.entity.Txn;
import com.customer.txn.repository.TxnRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TxnService {

    Logger log = LoggerFactory.getLogger(TxnService.class);

    @Autowired
    TxnRepository txnRepository;

    @Transactional
    public Txn createTxn(final String accountNumber, final String txnAmount, final String description, final Date txnDate,
                         String txnTime, Long customerId) {
        final Txn txn = new Txn();
        txn.setAccountNumber(accountNumber);
        txn.setTxnAmount(new BigDecimal(txnAmount).setScale(4, BigDecimal.ROUND_HALF_EVEN));
        txn.setDescription(description);
        txn.setTxnDate(txnDate);
        txn.setTxnTime(txnTime);
        txn.setCustomerId(customerId);
        return txnRepository.save(txn);
    }

    @Transactional(readOnly = true)
    public List<Txn> getAllTxns(final int count) {
        return txnRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Optional<Txn> getTxn(final Long id) {
        return txnRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Txn> getTxnByCustomerId(final Long customerId) {
        return txnRepository.findByCustomerId(customerId);
    }

    @Transactional(readOnly = true)
    public List<Txn> getTxnByCustomerId(final int first, final int after, final Long customerId) {
        return txnRepository.findByCustomerId(customerId).stream().skip(after).limit(first).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Txn> getTxnByDescription(final String description) {
        return txnRepository.findByDescription(description);
    }

    @Transactional(readOnly = true)
    public List<Txn> getTxnByDescription(final int first, final int after, final String description) {
        return txnRepository.findByDescription(description).stream().skip(after).limit(first).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Txn> getTxnByAccountNumbers(List<String> accountNumbers) {
        return txnRepository.findByAccountNumbers(accountNumbers);
    }

    @Transactional(readOnly = true)
    public List<Txn> getTxnByAccountNumbers(final int first, final int after, final List<String> accountNumbers) {
        return txnRepository.findByAccountNumbers(accountNumbers).stream().skip(after).limit(first).collect(Collectors.toList());
    }
}
