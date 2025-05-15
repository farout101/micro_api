package net.farout.springreactive.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "student")
// There's no entity annotation here in reactive programming
public class Student {
    @Id
    // In reactive programming, we use @Id instead of @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private int age;
}
