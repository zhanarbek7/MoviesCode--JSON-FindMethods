package com.company.Data;

import com.company.Data.Cast;
import com.company.Data.Director;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class Movies {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> cast = new ArrayList<>();

    void printCast() {
        int counter = 1;
        for (Cast s : cast) {
            System.out.printf("%s)   Fullname: %s\n", counter, s.getFullName());
            System.out.println("     Role: " + s.getRole());
            counter++;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(Cast cast) {
        this.cast.add(cast);
    }

    @Override
    public String toString() {
        return "Movies{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                ", director=" + director +
                ", cast=" + cast +
                '}';
    }
}
