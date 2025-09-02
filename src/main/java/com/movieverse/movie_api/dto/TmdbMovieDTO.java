package com.movieverse.movie_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TmdbMovieDTO {
    private Long id;
    private String title;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private Double voteAverage;

    @JsonProperty("poster_path")
    private String posterPath;

}