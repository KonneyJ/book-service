package org.bookservice.dto.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookShortResponseDto {
    private Long id;
    private String title;
    private int publicationYear;
    private String genre;
}
