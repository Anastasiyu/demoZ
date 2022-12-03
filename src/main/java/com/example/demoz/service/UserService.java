package com.example.demoz.service;

import com.example.demoz.exception.UserNotFoundException;
import com.example.demoz.exception.UserAlreadyAddedException;
import com.example.demoz.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public static List<User>distinct(List<User> users){                  //убрать дубликаты сравнение идет по методу equals
        return  users.stream().distinct().collect(Collectors.toList());
    }


    public User add(String name, int age) {             //метод добавления user
        User user = new User(name, age);

        if (users.contains(user)) {
            throw new UserAlreadyAddedException();  //user уже добавлен
        }
        return user;
    }

    public User remove(String name, int age) {    //метод удаления user
        User user = new User(name, age);
        if (users.contains(user)) {              //если в списке есть user
           users.remove(user);                   // удалить user
            return user;
        }
        throw new UserNotFoundException();  //user не найден
    }

    public User find(String name, int age) {          //поиск по имени и возрасту
        User user = new User(name, age);
        if (users.contains(user)) {
            return user;
        }
        throw new UserNotFoundException(); //user не найден
    }

    public List<User> findAll() {
        return  new ArrayList<>(users);
    }             //вывод списка всех

}
