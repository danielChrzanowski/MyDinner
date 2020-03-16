package com.handling;

public class User {

    public static User user;
    public String login, password, name, surname, email;

    private User() {
    }

    public static User getUser() {
        if (user == null) {
            user = new User();
        }

        return user;
    }

}
