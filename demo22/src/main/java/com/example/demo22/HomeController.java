package com.example.demo22;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    UserRepository repo;

    @RequestMapping("/")
    public String sayHello() {
        return "Hello";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return repo.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") int id) {

        for(User user : repo.getUsers()) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    @GetMapping("/calculate/{a}/{b}/{op}")
    public double calculate(@PathVariable("a") double a, @PathVariable("b") double b, @PathVariable("op") Operations op) {

        switch (op) {
            case ADD:
                return a+b;
            case SUBTRACT:
                return a-b;
            case MULTIPLY:
                return a*b;
            case DIVIDE:
                return a/b;
        }

        return 0.0;
    }

}
