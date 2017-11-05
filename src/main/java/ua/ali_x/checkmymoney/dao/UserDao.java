package ua.ali_x.checkmymoney.dao;

import org.springframework.data.repository.CrudRepository;
import ua.ali_x.checkmymoney.model.User;

public interface UserDao extends CrudRepository<User, Integer> {


}
