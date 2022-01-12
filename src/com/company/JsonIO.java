package com.company;

import com.company.Data.Movies;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class JsonIO {

    private static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();

    public static String readJson(String path) {
        StringBuilder json = new StringBuilder();
        try (FileReader fr = new FileReader(path)) {
            int c;
            while ((c = fr.read()) != -1) {
                json.append((char) c);
            }
            return json.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return json.toString();
    }

    public static List<Movies> getMovies() {
        Map<String, List<Movies>> moviesMap =
                GSON.fromJson(readJson("movies.json"),
                        new TypeToken<Map<String, List<Movies>>>() {}.getType());

        List<Movies> movies = new ArrayList<>();

        for (Map.Entry<String, List<Movies>> t : moviesMap.entrySet()) {
            movies.addAll(t.getValue());
        }
        return movies;

    }
}
