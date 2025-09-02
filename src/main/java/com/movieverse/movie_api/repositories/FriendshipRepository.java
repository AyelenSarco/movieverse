package com.movieverse.movie_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieverse.movie_api.models.Friendship;

public interface FriendshipRepository extends JpaRepository<Friendship, Long> {

}
