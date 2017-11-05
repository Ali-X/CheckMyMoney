package ua.ali_x.checkmymoney.service;

import ua.ali_x.checkmymoney.model.Transaction;
import ua.ali_x.checkmymoney.model.User;

import java.util.Optional;

/**
 * The class {@code UserService} includes methods for
 * operation with user data and database.
 */
public interface UserService {

    /**
     * Finds user in database by identificator
     *
     * @param id the non-null value to be present
     * @return optional with/without user object
     */
    Optional<User> getUserById(Integer id);

    /**
     * Updates user in database
     *
     * @param user the non-null value to be present
     * @return optional with/without user object
     */
    Optional<User> updateUser(User user);

    /**
     * Checks user by number of money in the wallet and
     * if user has enough money it subtracts transaction money from wallet money
     * and update user in database.
     *
     * @param transaction the non-null value to be present
     * @return boolean value of transaction operation status
     */
    boolean withdraw(Transaction transaction);

    /**
     * Adds transaction money to wallet money
     * and update user in database.
     *
     * @param transaction the non-null value to be present
     * @return boolean value if boolean value of transaction operation status
     */
    boolean enroll(Transaction transaction);

}
