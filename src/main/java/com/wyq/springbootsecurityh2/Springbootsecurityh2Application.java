package com.wyq.springbootsecurityh2;

import com.wyq.springbootsecurityh2.entity.User;
import com.wyq.springbootsecurityh2.respository.UserRespository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springbootsecurityh2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootsecurityh2Application.class, args);
    }

    @Bean
    InitializingBean saveData(UserRespository repo) {
        return () -> {
            repo.save(new User("iOS", "133", "o41Q65HO09DdN8eRg5ODuLrOpPII"));
            repo.save(new User("Orient", "138", null));
        };
    }

}

