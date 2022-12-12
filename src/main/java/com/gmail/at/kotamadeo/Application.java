package com.gmail.at.kotamadeo;

import com.gmail.at.kotamadeo.profile.SystemProfile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        try (var context = SpringApplication.run(Application.class, args)) {
            var bean = context.getBean(SystemProfile.class);
            System.out.println(bean.getProfile());
        }
    }

}
