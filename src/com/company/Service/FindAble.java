package com.company.Service;

import com.company.Data.Movies;

import java.util.List;

public interface FindAble {

    void findMoviesByActor(List<Movies> movies);

    void findMoviesByDirector(List<Movies> movies);

    void findMoviesByYear(List<Movies> movie, String year);

    void findMoviesAndRoleByActor(List<Movies> movies);

    void findMoviesByName(List<Movies> movies, String name);
}
