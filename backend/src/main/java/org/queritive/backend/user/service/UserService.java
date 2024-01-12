package org.queritive.backend.user.service;

import lombok.AllArgsConstructor;
import org.queritive.backend.user.entity.User;
import org.queritive.backend.user.exceptions.InvalidUserCredentialsException;
import org.queritive.backend.user.exceptions.UserNotFoundException;
import org.queritive.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String username, String password){
        if(!verifyPassword(username, password)){
            throw new InvalidUserCredentialsException("Username or password is incorrect");
        }
        return findUserByName(username);
    }

    private User findUserByName(String username){
        return userRepository.findById(username)
                .orElseThrow(() -> new UserNotFoundException("Cannot find user linked to username"));
    }

    private boolean verifyPassword(String username, String password){
        return password.equals(findUserByName(username).getPassword());
    }
}
