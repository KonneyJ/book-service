package org.bookservice.service.book;

import org.bookservice.dto.book.BookRequestDto;
import org.bookservice.dto.book.BookResponseDto;
import org.bookservice.dto.book.BookShortResponseDto;

import java.util.Collection;

public interface BookService {

    BookResponseDto createBook(BookRequestDto book);

    Collection<BookShortResponseDto> getAllBooks();

    BookResponseDto getBookById(Long id);

    BookResponseDto updateBook(Long id, BookRequestDto book);

    void deleteBook(Long id);
}
