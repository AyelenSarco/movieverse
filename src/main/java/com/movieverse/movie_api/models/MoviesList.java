package com.movieverse.movie_api.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "movies_list")
@Data
public class MoviesList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "creator_id", foreignKey = @ForeignKey(name = "CREATOR_ID_FK"))
    private User creator;

    // movies. One movie is necessary to create a list
    @OneToMany(mappedBy = "list", cascade = CascadeType.ALL)
    @Column(nullable = false)
    private List<MovieListItem> movies = new ArrayList<>();

    public MoviesList(String title, User creator) {
        this.title = title;
        this.creator = creator;
        this.created_at = LocalDate.now();
    }

}
