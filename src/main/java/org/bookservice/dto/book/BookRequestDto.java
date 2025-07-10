package org.bookservice.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDto {
    private String title;
    private Long authorId;
    private int publicationYear;
    private String genre;
}
