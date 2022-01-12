package com.company;

import com.company.Data.Cast;
import com.company.Data.Director;
import com.company.Data.Movies;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class Main {
//    private static final List<Movies> movies = JsonIO.getMovies();
//    private static SortAble s = (SortAble) new MovieStore();
//    private static FindAble f = (FindAble) new FindByMap();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InputException {
        List<Movies> movies = new ArrayList<Movies>();
        fillUpMovies(movies);
        for (Movies movie : movies) {
            System.out.println(movie);
        }
    }
    public static void fillUpMovies(List<Movies> movies){
        try{
            String data = new String(Files.readAllBytes(Path.of("movies.json")));
            JSONObject JObject = new JSONObject(data);
            // creating the Main json array to read movies from
            JSONArray array = JObject.getJSONArray("movies");
            for(int i = 0; i<array.length();i++){
                // every iteration will be created JSONObject of movie
                JSONObject movieIndexes = array.getJSONObject(i);
                Movies movie = new Movies();
                movie.setName(movieIndexes.getString("name"));
                movie.setYear(movieIndexes.getInt("year"));
                movie.setDescription("description");
                JSONObject directorInfo = movieIndexes.getJSONObject("director");
                Director director = new Director();
                director.setFullName(directorInfo.getString("fullName"));
                movie.setDirector(director);
                JSONArray castsArr = movieIndexes.getJSONArray("cast");
                for(int j = 0; j<castsArr.length(); j++){
                    JSONObject castsObj = castsArr.getJSONObject(j);
                    Cast cast = new Cast();
                    cast.setFullName(castsObj.getString("fullName"));
                    cast.setRole(castsObj.getString("role"));
                    movie.setCast(cast);
                }
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
