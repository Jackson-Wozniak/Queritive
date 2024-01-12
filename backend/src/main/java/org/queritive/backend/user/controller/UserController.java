package org.queritive.backend.user.controller;

import lombok.AllArgsConstructor;
import org.queritive.backend.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<?> getUserWithCredentials(@RequestParam("username") String username, @RequestParam("password") String password){
        return ResponseEntity.ok(userService.login(username, password).getUsername());
    }
}
