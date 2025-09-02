package com.movieverse.movie_api.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.movieverse.movie_api.repositories.UserRepository;
import com.movieverse.movie_api.models.User;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String username, String email, String planePassword) {
        String hashedPassword = passwordEncoder.encode(planePassword);
        User user = new User(email, username, hashedPassword);
        return userRepository.save(user);
    }
}
