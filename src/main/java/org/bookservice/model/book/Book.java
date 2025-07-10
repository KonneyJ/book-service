package org.bookservice.model.book;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "books")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Поле title не может быть пустым")
    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Long authorId;

    @NotBlank(message = "Поле publication_year не может быть пустым")
    @Column(name = "publication_year")
    private int publicationYear ;

    @NotBlank(message = "Поле genre не может быть пустым")
    @Column(name = "genre")
    private String genre;
}
