package com.company.Service;

import com.company.Data.Movies;

import java.util.List;

public interface FindAble {

    void findMoviesByActor(List<Movies> movies);

    void findMoviesByDirector(List<Movies> movies);

    void findMoviesByYear(List<Movies> movies, int name);

    void findMoviesAndRoleByActor(List<Movies> movies);

    void showActorRoles(List<Movies> movies);
}
