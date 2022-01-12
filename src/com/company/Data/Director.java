package com.company.Data;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class Director {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Director{" +
                "fullName='" + fullName + '\'' +
                '}';
    }
}
