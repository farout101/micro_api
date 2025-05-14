package net.farout.micro_api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MicroApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroApiApplication.class, args);
    }
}
