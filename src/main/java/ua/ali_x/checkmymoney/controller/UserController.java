package ua.ali_x.checkmymoney.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.ali_x.checkmymoney.model.User;
import ua.ali_x.checkmymoney.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable(value = "id") Integer id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.status(404)::build);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return userService.updateUser(user)
                .map(ResponseEntity.status(201)::body)
                .orElseGet(ResponseEntity.status(406)::build);
    }
}
