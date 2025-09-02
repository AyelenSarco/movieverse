package com.movieverse.movie_api.dto;

import java.util.List;

import lombok.Data;

@Data
public class TmdbResponseDTO {
    private int page;
    private List<TmdbMovieDTO> results;
    private int total_pages;
    private int total_results;

}