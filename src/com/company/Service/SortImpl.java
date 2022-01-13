package com.company.Service;

import com.company.Data.Cast;
import com.company.Data.Movies;

import java.util.*;

import static com.company.Main.ANSI_GREEN;
import static com.company.Main.printCatalog;
import static com.company.Service.FindImpl.scanner;
import static javax.swing.UIManager.get;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 12/1/22
 */
public class SortImpl implements SortAble{
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    List<Movies> movies = new ArrayList<>();

    @Override
    public void sortByYear(List<Movies> movies) {
        this.movies = movies;
        movies.sort(new Comparator<Movies>() {
            @Override
            public int compare(Movies o1, Movies o2) {
                return o1.getYear()-o2.getYear();
            }
        });
        System.out.println(ANSI_YELLOW+"Press 1 to sort ascending"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"Press 2 to sort descending"+ANSI_RESET);
        int c = scanner.nextInt();
        switch(c){
            case 1->{
                System.out.println(ANSI_YELLOW+"-------------------Sorting movies ascending by YEARS--------------------"+ANSI_RESET);
                printCatalog(movies);
                System.out.println(ANSI_GREEN+"Successfully printed out movies ascending by years!"+ANSI_RESET);
            }
            case 2->{
                int p = 1;
                System.out.println(ANSI_YELLOW+"-------------------Sorting movies descending by YEARS--------------------"+ANSI_RESET);
                for(int i = movies.size()-1; i >= 0; i--){
                    System.out.println("----#"+p+"----");
                    System.out.println(ANSI_PURPLE+"Name: "+ANSI_RESET+movies.get(i).getName());
                    System.out.println(ANSI_PURPLE+"Year: "+ANSI_RESET+movies.get(i).getYear());
                    System.out.println(ANSI_PURPLE+"Description: "+ANSI_RESET+movies.get(i).getDescription());
                    System.out.println(ANSI_PURPLE+"Director: "+ANSI_RESET+movies.get(i).getDirector().getFullName());
                    System.out.println(ANSI_YELLOW+"*Cast of "+movies.get(i).getName()+"*"+ANSI_RESET);
                    for (int j = 0; j<movies.get(i).getCast().size(); j++){
                        int k = j;
                        k++;
                        System.out.println(ANSI_PURPLE+k+")    Fullname: "+ANSI_RESET+movies.get(i).getCast().get(j).getFullName());
                        System.out.println(ANSI_PURPLE+"      Role: "+ANSI_RESET+movies.get(i).getCast().get(j).getRole());
                    }
                    p++;
                }
                System.out.println(ANSI_GREEN+"Successfully printed out movies descending by years!"+ANSI_RESET);

            }
            default -> {
                System.out.println(ANSI_RED+"There is no such kind of option!"+ANSI_RESET);
            }
        }
    }
    @Override
    public void sortByName(List<Movies> movies) {
        this.movies = movies;
        movies.sort(new Comparator<Movies>() {
            @Override
            public int compare(Movies o1, Movies o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(ANSI_YELLOW+"Press 1 to sort ascending"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"Press 2 to sort descending"+ANSI_RESET);
        String c = scanner.nextLine();
        switch(c){
            case "1"->{
                System.out.println(ANSI_YELLOW+"-------------------Sorting movies ascending by MOVIE-NAME--------------------"+ANSI_RESET);
                printCatalog(movies);
                System.out.println(ANSI_PURPLE+"Successfully printed out ascending by MOVIE-NAME!"+ANSI_RESET);

            }
            case "2"->{
                int p = 1;
                System.out.println(ANSI_YELLOW+"-------------------Sorting movies descending by MOVIE-NAME--------------------"+ANSI_RESET);
                for(int i = movies.size()-1; i >= 0; i--){
                    System.out.println("----#"+p+"----");
                    System.out.println(ANSI_PURPLE+"Name: "+ANSI_RESET+movies.get(i).getName());
                    System.out.println(ANSI_PURPLE+"Year: "+ANSI_RESET+movies.get(i).getYear());
                    System.out.println(ANSI_PURPLE+"Description: "+ANSI_RESET+movies.get(i).getDescription());
                    System.out.println(ANSI_PURPLE+"Director: "+ANSI_RESET+movies.get(i).getDirector().getFullName());
                    System.out.println(ANSI_YELLOW+"*Cast of "+movies.get(i).getName()+"*"+ANSI_RESET);
                    for (int j = 0; j<movies.get(i).getCast().size(); j++){
                        int k = j;
                        k++;
                        System.out.println(ANSI_PURPLE+k+")    Fullname: "+ANSI_RESET+movies.get(i).getCast().get(j).getFullName());
                        System.out.println(ANSI_PURPLE+"      Role: "+ANSI_RESET+movies.get(i).getCast().get(j).getRole());
                    }
                    p++;
                }
                System.out.println(ANSI_PURPLE+"Successfully printed out descending by MOVIE-NAME!"+ANSI_RESET);

            }
            default->{
                System.out.println(ANSI_RED+"There is no such kind of option"+ANSI_RESET);
            }
        }
    }
    @Override
    public void sortByDirector(List<Movies> movies) {
        this.movies = movies;
        movies.sort(new Comparator<Movies>() {
            @Override
            public int compare(Movies o1, Movies o2) {
                return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
            }
        });
        System.out.println(ANSI_YELLOW+"Press 1 to sort ascending"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"Press 2 to sort descending"+ANSI_RESET);
        String c = scanner.nextLine();
        switch(c){
            case "1"->{
                System.out.println(ANSI_YELLOW+"-------------------Sorting movies ascending by Director's name--------------------"+ANSI_RESET);
                printCatalog(movies);
                System.out.println(ANSI_PURPLE+"Successfully printed out ascending by Director's name!"+ANSI_RESET);
            }
            case "2"->{
                int p = 1;
                System.out.println(ANSI_YELLOW+"-------------------Sorting movies descending by Director's name--------------------"+ANSI_RESET);
                for(int i = movies.size()-1; i >= 0; i--){
                    System.out.println("----#"+p+"----");
                    System.out.println(ANSI_PURPLE+"Name: "+ANSI_RESET+movies.get(i).getName());
                    System.out.println(ANSI_PURPLE+"Year: "+ANSI_RESET+movies.get(i).getYear());
                    System.out.println(ANSI_PURPLE+"Description: "+ANSI_RESET+movies.get(i).getDescription());
                    System.out.println(ANSI_PURPLE+"Director: "+ANSI_RESET+movies.get(i).getDirector().getFullName());
                    System.out.println(ANSI_YELLOW+"*Cast of "+movies.get(i).getName()+"*"+ANSI_RESET);
                    for (int j = 0; j<movies.get(i).getCast().size(); j++){
                        int k = j;
                        k++;
                        System.out.println(ANSI_PURPLE+k+")    Fullname: "+ANSI_RESET+movies.get(i).getCast().get(j).getFullName());
                        System.out.println(ANSI_PURPLE+"      Role: "+ANSI_RESET+movies.get(i).getCast().get(j).getRole());
                    }
                    p++;
                }
                System.out.println(ANSI_PURPLE+"Successfully printed out descending by Director's name!"+ANSI_RESET);

            }
            default -> {
                System.out.println(ANSI_RED+"There is no such kind of option!"+ANSI_RESET);
            }
        }
    }
    @Override
    public void sortAllActors(List<Movies> movies) {
        this.movies = movies;
        List<String> casts = new ArrayList<>();
        for (Movies movie : movies) {
            for (int j = 0; j < movie.getCast().size(); j++) {
                if (!casts.contains(movie.getCast().get(j).getFullName())) {
                    casts.add(movie.getCast().get(j).getFullName());
                }
            }
        }
        System.out.println(ANSI_YELLOW+"Press 1 to sort ascending"+ANSI_RESET);
        System.out.println(ANSI_YELLOW+"Press 2 to sort descending"+ANSI_RESET);
        int id = scanner.nextInt();
        switch(id){
            case 1-> Collections.sort(casts);
            case 2-> casts.sort(Collections.reverseOrder());
            default -> System.out.println(ANSI_RED+"There is no such kind of option!"+ANSI_RESET);
        }
        if(id==1||id==2){
            int c = 1;
            for (String cast : casts) {
                System.out.println("------------------------------");
                System.out.println("Actor: " + cast);
                System.out.println("------------------------------");
                for (Movies movie : movies) {
                    for (int k = 0; k < movie.getCast().size(); k++) {
                        if (movie.getCast().get(k).getFullName().equals(cast)) {
                            System.out.println(c+") Name: " + movie.getName());
                            System.out.println("Role: " + movie.getCast().get(k).getRole());
                            c++;
                        }
                    }
                }
                c=1;
            }
        }

    }
}
