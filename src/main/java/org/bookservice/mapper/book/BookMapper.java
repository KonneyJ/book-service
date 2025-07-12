package org.bookservice.mapper.book;

import org.bookservice.dto.book.BookRequestDto;
import org.bookservice.dto.book.BookResponseDto;
import org.bookservice.dto.book.BookShortResponseDto;
import org.bookservice.mapper.author.AuthorMapper;
import org.bookservice.model.author.Author;
import org.bookservice.model.book.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static Book toBook(BookRequestDto newBook, Author author) {
        return Book.builder()
                .title(newBook.getTitle())
                .author(author)
                .publicationYear(newBook.getPublicationYear())
                .genre(newBook.getGenre())
                .build();
    }

    public static BookResponseDto toBookDto(Book book, Author author) {
        return BookResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(AuthorMapper.toAuthorDto(author))
                .publicationYear(book.getPublicationYear())
                .genre(book.getGenre())
                .build();
    }

    public static BookShortResponseDto toBookShortDto(Book book) {
        return BookShortResponseDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .publicationYear(book.getPublicationYear())
                .genre(book.getGenre())
                .build();
    }
}
