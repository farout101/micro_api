package net.farout.springreactive.service;

import lombok.RequiredArgsConstructor;
import net.farout.springreactive.model.Student;
import net.farout.springreactive.repository.StudentRepo;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public Mono<Student> save(Student student) {
        return studentRepo.save(student);
    }

    // FLux means a list of objects
    public Flux<Student> findAll() {
        return studentRepo.findAll();
    }
    // Mono means one object
    public Mono<Student> findById(Integer id) {
        return studentRepo.findById(id);
    }
}
