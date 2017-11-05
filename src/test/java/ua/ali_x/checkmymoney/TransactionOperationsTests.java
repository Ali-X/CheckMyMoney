package ua.ali_x.checkmymoney;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ali_x.checkmymoney.model.Transaction;
import ua.ali_x.checkmymoney.model.TransactionType;
import ua.ali_x.checkmymoney.model.User;
import ua.ali_x.checkmymoney.service.TransactionService;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionOperationsTests {

    @Autowired
    private TransactionService transactionService;
    private User user;
    private Transaction transaction;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1);
        user.setEmail("old@mail.com");
        user.setPassword("pass");
        user.setMoney(new BigDecimal(10));

        transaction = new Transaction();
        transaction.setNumber(new BigDecimal(11));
        transaction.setUser(user);
    }

    @Test
    public void subtractMoneyTest() {
        transaction.setType(TransactionType.WITHDRAWAL);
        transactionService.createTransaction(transaction);
    }

    @Test
    public void addMoneyTest() {
        transaction.setType(TransactionType.ENLISTMENT);
        transactionService.createTransaction(transaction);
    }
}
