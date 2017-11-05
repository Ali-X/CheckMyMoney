package ua.ali_x.checkmymoney.service;

import ua.ali_x.checkmymoney.model.Transaction;

import java.util.Optional;

/**
 * The class {@code TransactionService} includes method for saving
 * user transaction to database.
 * <p>
 * But user can have number of money in the wallet less than summ of transaction.
 * Method in this class will cause a {@link RuntimeException} to be
 * thrown.
 */
public interface TransactionService {

    /**
     * Checks type of transaction and save transaction to database.
     *
     * @param transaction the non-null value to be present
     * @return optional with/without transaction object
     * @throws RuntimeException if user dosn't have enough money for transaction
     */
    Optional<Transaction> createTransaction(Transaction transaction);

}
