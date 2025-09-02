package com.movieverse.movie_api.repositories;

import com.movieverse.movie_api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Puedes agregar búsquedas personalizadas después si quieres
}