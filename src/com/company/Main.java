package com.company;

import com.company.Data.Cast;
import com.company.Data.Director;
import com.company.Data.Movies;
import com.company.Service.FindImpl;
import com.company.Service.SortImpl;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void main(String[] args) throws InputException {
        List<Movies> movies = new ArrayList<Movies>();
        fillUpMovies(movies);
        while(true) {
            FindImpl find = new FindImpl();
            SortImpl sort = new SortImpl();
            commands();
            String num = scanner.nextLine().toLowerCase(Locale.ROOT);
            switch (num) {
                case "1" -> {
                    System.out.println(ANSI_YELLOW + "-------------------All movies--------------------" + ANSI_RESET);
                    printCatalog(movies);
                    System.out.println(ANSI_GREEN + "Successfully printed out whole catalog!" + ANSI_RESET);
                }
                case "2" -> {
                    System.out.println(ANSI_YELLOW + "Write movie's name: " + ANSI_RESET);
                    String movieName = scanner.nextLine();
                    if (movieName.equals("")) {
                        System.out.println(ANSI_RED + "There is no such kind of Movie!!!");
                    } else {
                        find.findMoviesByName(movies, movieName);
                    }
                }
                case "3" -> {
                    sort.sortByYear(movies);
                }
                case "4" -> {
                    sort.sortByName(movies);
                }
                case "5" -> {
                    sort.sortByDirector(movies);
                }
                case "6" -> {
                    find.findMoviesByActor(movies);
                }
                case "7" -> {
                    find.findMoviesByDirector(movies);
                }
                case "8" -> {
                    System.out.println(ANSI_YELLOW + "Enter the year: " + ANSI_RESET);
                    String year = scanner.nextLine();
                    find.findMoviesByYear(movies, year);
                }
                case "9" -> {
                    find.findMoviesAndRoleByActor(movies);
                }
                case "10" -> {
                    sort.sortAllActors(movies);
                }
                case "x" -> {
                    System.exit(0);
                }
                default -> {
                    System.out.println(ANSI_RED + "No such kind of button!!!");
                }
            }

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
    public static void commands() {
        System.out.println(ANSI_YELLOW+"--------------------Commands----------------------"+ANSI_RESET);
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sort out List of all actors with his roles");
        System.out.println(ANSI_RED+"Press x if you wish to exit the program!"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"-------------------------------------------------"+ANSI_RESET);
    }
    public static void printCatalog(List<Movies> movies){
        for(int i = 0; i < movies.size(); i++){
            i++;
            System.out.println(ANSI_GREEN+"-------------------------#"+i+"-----------------------"+ANSI_RESET);
            i--;
            System.out.println(ANSI_PURPLE+"Name:         "+ANSI_RESET+movies.get(i).getName());
            System.out.println(ANSI_PURPLE+"Year:         "+ANSI_RESET+movies.get(i).getYear());
            System.out.println(ANSI_PURPLE+"Description:  "+ANSI_RESET+movies.get(i).getDescription());
            System.out.println(ANSI_PURPLE+"Director:     "+ANSI_RESET+movies.get(i).getDirector().getFullName());
            System.out.println(ANSI_YELLOW+"*Cast of "+movies.get(i).getName()+"*"+ANSI_RESET);
            for (int j = 0; j<movies.get(i).getCast().size(); j++){
                int k = j;
                k++;
                System.out.println(ANSI_PURPLE+k+") Fullname:  "+ANSI_RESET+movies.get(i).getCast().get(j).getFullName());
                System.out.println(ANSI_PURPLE+"   Role:      "+ANSI_RESET+movies.get(i).getCast().get(j).getRole());
            }
        }
    }

}
