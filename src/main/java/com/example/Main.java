package com.example;

import com.example.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PersistenceConfig.class);

        context.close();
    }
}
