package org.bookservice.mapper;

import org.bookservice.dto.author.AuthorRequestDto;
import org.bookservice.dto.author.AuthorResponseDto;
import org.bookservice.model.author.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public static Author toAuthor(AuthorRequestDto newAuthor) {
        return Author.builder()
                .name(newAuthor.getName())
                .birthYear(newAuthor.getBirthYear())
                .build();
    }

    public static AuthorResponseDto toAuthorDto(Author author) {
        return AuthorResponseDto.builder()
                .id(author.getId())
                .name(author.getName())
                .birthYear(author.getBirthYear())
                .build();
    }
}
