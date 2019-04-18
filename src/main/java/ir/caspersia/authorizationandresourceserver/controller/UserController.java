package ir.caspersia.authorizationandresourceserver.controller;

import ir.caspersia.authorizationandresourceserver.model.entity.DTO.Response;
import ir.caspersia.authorizationandresourceserver.model.entity.User;
import ir.caspersia.authorizationandresourceserver.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Response<User>> registerUser(@RequestBody User user) {
        User persistedUser = userService.registerUser(user);
        return new ResponseEntity<>(new Response<User>()
                                            .ok()
                                            .setMessage(persistedUser)
                                            .setPath("/user"), HttpStatus.OK);
    }
}
