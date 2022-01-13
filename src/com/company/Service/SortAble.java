package com.company.Service;

import com.company.Data.Movies;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public interface SortAble {
    void sortByYear(List<Movies> movies);

    void sortByName(List<Movies> movies);

    void sortByDirector(List<Movies> movies);

    void sortAllActors(List<Movies> movies);

}
