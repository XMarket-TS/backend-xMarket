package com.bo.xMarket.bl;

import com.bo.xMarket.dao.TransactionDao;
import com.bo.xMarket.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionBl {
    private final TransactionDao transactionDao;

    @Autowired
    public TransactionBl(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    public Transaction createTransaction(Transaction transaction) {
        this.transactionDao.create(transaction);
        Integer lastPrimaryKey = this.transactionDao.getLastInsertId();
        transaction.setTxId(lastPrimaryKey);
        return transaction;
    }
}
