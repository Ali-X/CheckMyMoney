package ua.ali_x.checkmymoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ali_x.checkmymoney.dao.TransactionDao;
import ua.ali_x.checkmymoney.model.Transaction;
import ua.ali_x.checkmymoney.model.TransactionType;

import java.util.Optional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;
    @Autowired
    private UserService userService;

    @Override
    public Optional<Transaction> createTransaction(Transaction transaction) {
        boolean result;
        if (transaction.getType() == TransactionType.WITHDRAWAL) {
            result = userService.withdraw(transaction);
            if (!result) throw new RuntimeException("You don't have enough money!");
        }
        if (transaction.getType() == TransactionType.ENLISTMENT) {
            result = userService.enroll(transaction);
        }
        return Optional.ofNullable(transactionDao.save(transaction));
    }
}
