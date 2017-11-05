package ua.ali_x.checkmymoney;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.ali_x.checkmymoney.model.User;
import ua.ali_x.checkmymoney.service.UserService;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserOperationsTests {

    @Autowired
    private UserService userService;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setId(1);
        user.setEmail("old@mail.com");
        user.setPassword("pass");
        user.setMoney(new BigDecimal(10));
    }

    @Test
    public void getUserTest() {
        userService.getUserById(user.getId());
    }

    @Test
    public void updateUserTest() {
        user.setEmail("new@mail.com");
        userService.updateUser(user);
    }
}
