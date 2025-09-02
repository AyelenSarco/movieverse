package com.movieverse.movie_api.dto;

// to return information about an item in a list
public class MovieListItemResponseDTO {
    private Long id;
    private int position;
    private String notes;
    private MovieResponseDTO movie; // DTO
}