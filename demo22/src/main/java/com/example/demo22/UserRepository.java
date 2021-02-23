package com.example.demo22;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> users = Arrays.asList(
            new User(1, "Parviz", "1234"),
            new User(2, "Adil", "asdf"),
            new User(3, "Cavid", "qwert")
    );

    public List<User> getUsers() {
        return users;
    }
}
