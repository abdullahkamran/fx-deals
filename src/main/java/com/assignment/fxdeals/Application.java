package com.assignment.fxdeals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.TimeZone;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        init();
        SpringApplication.run(Application.class, args);
    }

    protected static void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Locale.setDefault(Locale.US);
    }
}
