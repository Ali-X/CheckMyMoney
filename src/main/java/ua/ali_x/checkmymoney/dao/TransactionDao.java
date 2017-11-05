package ua.ali_x.checkmymoney.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ali_x.checkmymoney.model.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Integer> {
}
