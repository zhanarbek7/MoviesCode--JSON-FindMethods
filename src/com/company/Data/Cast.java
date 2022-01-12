package com.company.Data;

/**
 * Project: MoviesCode
 * Author: Zhanarbek Abdurasulov
 * Date: 10/1/22
 */
public class Cast {
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
}
