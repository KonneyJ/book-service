package org.bookservice.service.author;

import org.bookservice.dto.author.AuthorRequestDto;
import org.bookservice.dto.author.AuthorResponseDto;

import java.util.Collection;

public interface AuthorService {

    AuthorResponseDto createAuthor(AuthorRequestDto author);

    AuthorResponseDto getAuthorById(Long id);

    Collection<AuthorResponseDto> getAllAuthors(int page, int size);
}
