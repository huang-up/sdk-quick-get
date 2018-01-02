package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by admin on 2018/1/2.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        // 1.if just simple use to start spring boot application, use as below
        SpringApplication app = new SpringApplication();
        app.run(Application.class, args);

        // 2.if need config hierarchy context or default properties or active profiles
        /*SpringApplicationBuilder sab = new SpringApplicationBuilder(Application.class);
        // if not set, auto detected by classpath
        sab.web(true);
        sab.run(args);*/
    }
    @Override
    public void run(String... strings) throws Exception {}
}
