package org.bookservice.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bookservice.dto.author.AuthorResponseDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponseDto {
    private Long id;
    private String title;
    private AuthorResponseDto author;
    private int publicationYear;
    private String genre;
}
