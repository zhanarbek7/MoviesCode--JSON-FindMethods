package com.company.Service;
import com.company.Data.Movies;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static com.company.Main.*;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class FindImpl implements FindAble{
    static Scanner scanner = new Scanner(System.in);
    List<Movies> movies = new ArrayList<>();


    @Override
    public void findMoviesByActor(List<Movies> movies) {
        System.out.println(ANSI_YELLOW+"Write actor name: "+ANSI_RESET);
        String name = scanner.nextLine();
        int counter = 0, id = 0;
        this.movies = movies;
        List<Movies> fakeMovies = new ArrayList<>();
        List<String> names = new ArrayList<>();
        if(!name.isEmpty()){
            for (Movies movie : movies) {
                for (int j = 0; j < movie.getCast().size(); j++) {
                    if (movie.getCast().get(j).getFullName().contains(name)) {
                        fakeMovies.add(movie);
                    }
                }
            }
            for(int i = 0; i<fakeMovies.size(); i++){
                for(int j = 0; j<fakeMovies.get(i).getCast().size();j++){
                    if(fakeMovies.get(i).getCast().get(j).getFullName().contains(name)){
                        names.add(fakeMovies.get(i).getCast().get(j).getFullName());
                        counter++;
                    }
                }
            }
            for(int i = 0; i < fakeMovies.size(); i++){
                i++;
                System.out.println("---------------#"+i+"------------");
                i--;
                System.out.println(ANSI_PURPLE+"Name: "+ANSI_RESET+fakeMovies.get(i).getName());
                System.out.println(ANSI_PURPLE+"Year: "+ANSI_RESET+fakeMovies.get(i).getYear());
                System.out.println(ANSI_PURPLE+"Description: "+ANSI_RESET+names.get(0));
            }
        }
        if(counter>0){
            System.out.println(ANSI_GREEN+"Successfully printed out movies' by actor's name!"+ANSI_RESET);
        }
        else{
            System.out.println(ANSI_RED+"There is no such kind of actor!"+ANSI_RESET);
        }
    }

    @Override
    public void findMoviesByDirector(List<Movies> movies) {
        this.movies = movies;
        System.out.println(ANSI_YELLOW+"Write director's name: "+ANSI_RESET);
        String name = scanner.nextLine();
        int counter = 0;
        this.movies = movies;
        List<Movies> fakeMovies = new ArrayList<>();
        if(!name.isEmpty()){
            for (Movies movie : movies) {
                if (movie.getDirector().getFullName().contains(name)) {
                    fakeMovies.add(movie);
                    counter++;
                }
            }
            printCatalog(fakeMovies);
            if(counter!=0){
                System.out.println(ANSI_GREEN+"Successfully done finding movies by directors name!!!"+ANSI_RESET);
            }
            else{
                System.out.println(ANSI_RED+"There is no such kind of director!"+ANSI_RESET);

            }
        }
        else{
            System.out.println(ANSI_RED+"There is no such kind of director!"+ANSI_RESET);
        }
    }

    @Override
    public void findMoviesByYear(List<Movies> movies, String year) {
        this.movies = movies;
        List<Movies> fakeMovies = new ArrayList<>();
        int counter = 0;
        if(!year.isEmpty()){
            for (Movies movie : movies) {
                if (String.valueOf(movie.getYear()).equals(year)) {
                    fakeMovies.add(movie);
                    counter++;
                }
            }
            printCatalog(fakeMovies);
            if(counter!=0){
                System.out.println(ANSI_GREEN+"Successfully done finding movies by years!!!"+ANSI_RESET);
            }
            else{
                System.out.println(ANSI_RED+"Failed to find movies by written year"+ANSI_RESET);
            }
        }
        else{
            System.out.println(ANSI_RED+"There is no such kind of year"+ANSI_RESET);
        }


    }

    @Override
    public void findMoviesAndRoleByActor(List<Movies> movies) {
        System.out.println(ANSI_YELLOW+"Write actor name: "+ANSI_RESET);
        String name = scanner.nextLine();
        int counter = 0;
        this.movies = movies;
        List<Movies> fakeMovies = new ArrayList<>();
        if(!name.isEmpty()){
            for (Movies movie : movies) {
                for (int j = 0; j < movie.getCast().size(); j++) {
                    if (movie.getCast().get(j).getFullName().contains(name)) {
                        fakeMovies.add(movie);
                        counter++;
                    }
                }
            }
        }
        if(counter!=0){
            printCatalog(fakeMovies);
            System.out.println(ANSI_GREEN+"Successfully printed out all movies by actor's name"+ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED+"There is no such kind of actor"+ANSI_RESET);
        }
    }

    @Override
    public void findMoviesByName(List<Movies> movies, String movieName) {
        this.movies = movies;
        int counter = 0;
            for(int i = 0; i< movies.size(); i++) {
                if(movies.get(i).getName().contains(movieName)){
                    i++;
                    System.out.println("----#"+i+"----");
                    i--;
                    System.out.println(ANSI_PURPLE+"Name: "+ANSI_RESET+movies.get(i).getName());
                    System.out.println(ANSI_PURPLE+"Description: "+ANSI_RESET+movies.get(i).getDescription());
                    System.out.println(ANSI_PURPLE+"Director: "+ANSI_RESET+movies.get(i).getDirector().getFullName());
                    System.out.println(ANSI_YELLOW+"*Cast of "+movies.get(i).getName()+"*"+ANSI_RESET);
                    for (int j = 0; j<movies.get(j).getCast().size(); j++){
                        int k = j;
                        k++;
                        System.out.println(ANSI_PURPLE+k+")    Fullname: "+ANSI_RESET+movies.get(i).getCast().get(j).getFullName());
                        System.out.println(ANSI_PURPLE+"      Role: "+ANSI_RESET+movies.get(i).getCast().get(j).getRole());
                        counter++;
                    }
                }
            }
        if(counter!=0){
            System.out.println(ANSI_GREEN+"Successfully done finding by movie NAME!!!"+ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED+"There is no such kind of Movie!!!");
        }
        }



    }

