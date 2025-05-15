package net.farout.springreactive.repository;

import net.farout.springreactive.model.Student;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepo extends ReactiveCrudRepository<Student, Integer> {

    Flux<Student> findAllByFirstname(String firstname);
}