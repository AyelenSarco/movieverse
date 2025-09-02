package com.movieverse.movie_api.dto;

import java.time.LocalDate;
import java.util.List;

//To return information about de movie List and the movies in it
public class MoviesListResponseDTO {
    private Long id;
    private String title;
    private String notes;
    private String creatorUsername; // opctonal, insted of using all the User Object
    private LocalDate createdAt;
    private List<MovieListItemResponseDTO> items; // DTOs
}
