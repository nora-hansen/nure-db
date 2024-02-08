package eu.nurenur.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
    TODO
        - Models
            File
            Video
        - Repository
            All
        - Controller
            All
        - README
        - Database
            TO COME
        - Frontend
            TO COME
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
