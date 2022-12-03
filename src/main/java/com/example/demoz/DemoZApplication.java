package com.example.demoz;

import com.example.demoz.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoZApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoZApplication.class, args);


        List<User> users = new ArrayList<>();
        users.add(new User("Иван Иванов", 45));
        users.add(new User("Сергей Иванов", 25));
        users.add(new User("Петр Иванов", 55));
        users.add(new User("Иван Иванов", 45));

        System.out.println(distinct(users));
    }
        public static List<User>distinct(List<User> users){                  //убрать дубликаты сравнение идет по методу equals
            return  users.stream().distinct().collect(Collectors.toList());
    }
}


