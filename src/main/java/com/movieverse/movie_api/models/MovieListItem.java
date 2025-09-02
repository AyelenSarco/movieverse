package com.movieverse.movie_api.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movie_list_item")
@Data
public class MovieListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int position;

    private String notes;

    @ManyToOne
    @JoinColumn(name = "list_id", foreignKey = @ForeignKey(name = "LIST_ID_FK"))
    private MoviesList list;

    @ManyToOne
    @JoinColumn(name = "movie_id", foreignKey = @ForeignKey(name = "MOVIE_ID_FK"))
    private Movie movie;
}
