package com.movieverse.movie_api.config;

import com.movieverse.movie_api.models.Friendship;
import com.movieverse.movie_api.models.User;
import com.movieverse.movie_api.repositories.FriendshipRepository;
import com.movieverse.movie_api.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final FriendshipRepository friendshipRepository;
    private final PasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, FriendshipRepository friendshipRepository,
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.friendshipRepository = friendshipRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {

            User user = new User("pepe@example.com", "pepito", passwordEncoder.encode("1234"));
            userRepository.save(user);
            System.out.println("✅ Usuario" + user.getUsername() + " insertado con éxito");

            User user2 = new User("caro@example.com", "caro", passwordEncoder.encode("1234"));
            userRepository.save(user2);
            System.out.println("User" + user2.getUsername() + " added with succes");

            Friendship friendship = new Friendship(user, user2);
            friendshipRepository.save(friendship);
            System.out.println("Friendshipp added with succes");

        }
    }
}
