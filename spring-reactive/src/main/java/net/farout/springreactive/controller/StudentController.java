package net.farout.springreactive.controller;

import lombok.RequiredArgsConstructor;
import net.farout.springreactive.model.Student;
import net.farout.springreactive.service.StudentService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("api/test/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Mono<Student> save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping
    public Flux<Student> findAll() {
        return studentService.findAll()
                .delayElements(Duration.ofSeconds(1));
    }

    @GetMapping("/{id}")
    public Mono<Student> findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }
}
