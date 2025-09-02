package com.movieverse.movie_api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean isPrivate; // true = privated profile, false = public profile

    private String bio;

    @Column(nullable = true)
    private LocalDate createdAt;

    // friendships started by this user
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Friendship> friends = new ArrayList<>();

    // friendships where this user was added as friend
    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<Friendship> friendOf = new ArrayList<>();

    // ranking o recommendations list created by this user
    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL)
    private List<MoviesList> lists = new ArrayList<>();

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.createdAt = LocalDate.now();
    }

}
