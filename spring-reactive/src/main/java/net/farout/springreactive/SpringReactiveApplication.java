package net.farout.springreactive;

import net.farout.springreactive.model.Student;
import net.farout.springreactive.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringReactiveApplication.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService) {
        return args -> {
            for(int i = 0; i < 10; i++) {
                studentService.save(Student.builder()
                        .firstname("John " + i)
                        .lastname(" Doe")
                        .age(20 + i)
                        .build()).subscribe();
            };
        };
    }
}