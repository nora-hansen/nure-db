package eu.nurenur.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
    TODO
        - Models
            Group
            Image
            Character
        - Repository
            All
        - Controller
            All
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
