package com.movieverse.movie_api.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

enum FriendshipStatus {
    ACCEPTED, CANCELED, PENDING
}

@Entity
@Table(name = "friendship")
@Data
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_ID_FK"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "friend_id", foreignKey = @ForeignKey(name = "FRIEND_ID_FK"))
    private User friend;

    @Column(nullable = false)
    private LocalDate created_at;

    @Column(nullable = false)
    private FriendshipStatus status;

    public Friendship(User user, User friend) {
        this.user = user;
        this.friend = friend;
        this.created_at = LocalDate.now();
        this.status = FriendshipStatus.PENDING;
    }

}
