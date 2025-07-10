package org.bookservice.model.author;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "authors")
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long id;

    @NotBlank(message = "Поле name не может быть пустым")
    @Column(name = "name")
    private String name;

    @Column(name = "birth_year")
    private int birthYear;
}
