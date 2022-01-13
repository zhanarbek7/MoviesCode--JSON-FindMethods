package com.company.Data;

import java.util.Comparator;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class Cast implements Comparator<Cast> {
    private String fullName;
    private String role;

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Cast{" +
                "fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }


    @Override
    public int compare(Cast o1, Cast o2) {
        return o1.getRole().compareTo(o2.getRole());
    }
}
