package com.moviesSeries.services;

import com.moviesSeries.model.User;
import com.moviesSeries.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User registerUser(String username, String password, String email){
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);

        return userRepository.save(user);
    }
    public User authenticate(String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}
