package ua.ali_x.checkmymoney.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ali_x.checkmymoney.dao.UserDao;
import ua.ali_x.checkmymoney.model.Transaction;
import ua.ali_x.checkmymoney.model.User;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Optional<User> getUserById(Integer id) {
        return Optional.ofNullable(userDao.findOne(id));
    }


    @Override
    public Optional<User> updateUser(User user) {
        return Optional.ofNullable(userDao.save(user));
    }


    @Override
    public boolean withdraw(Transaction transaction) {
        User user = transaction.getUser();
        BigDecimal walletMoney = user.getMoney();
        BigDecimal transactionMoney = transaction.getNumber();
        walletMoney = walletMoney.subtract(transactionMoney);
        if (walletMoney.compareTo(BigDecimal.ZERO) < 0) {
            return false;
        }
        user.setMoney(walletMoney);
        userDao.save(user);
        return true;
    }


    @Override
    public boolean enroll(Transaction transaction) {
        User user = transaction.getUser();
        BigDecimal walletMoney = user.getMoney();
        BigDecimal transactionMoney = transaction.getNumber();
        walletMoney = walletMoney.add(transactionMoney);
        user.setMoney(walletMoney);
        userDao.save(user);
        return true;
    }
}
