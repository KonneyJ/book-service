package org.bookservice.controller.book;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bookservice.dto.book.BookRequestDto;
import org.bookservice.dto.book.BookResponseDto;
import org.bookservice.dto.book.BookShortResponseDto;
import org.bookservice.service.book.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookResponseDto createBook(@Valid @RequestBody BookRequestDto book) {
        return service.createBook(book);
    }

    @GetMapping
    public Collection<BookShortResponseDto> getAllBooks() {
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponseDto getBookById(@PathVariable("id") Long id) {
        return service.getBookById(id);
    }

    @PutMapping("/{id}")
    public BookResponseDto updateBook(@PathVariable("id") Long id, @Valid @RequestBody BookRequestDto book) {
        return service.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable("id") Long id) {
        service.deleteBook(id);
    }
}
