package org.bookservice.controller.author;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.RequiredArgsConstructor;
import org.bookservice.dto.author.AuthorRequestDto;
import org.bookservice.dto.author.AuthorResponseDto;
import org.bookservice.service.author.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorResponseDto createAuthor(@Valid @RequestBody AuthorRequestDto author) {
        return service.createAuthor(author);
    }

    @GetMapping("/{id}")
    public AuthorResponseDto getAuthorById(@PathVariable("id") Long id) {
        return service.getAuthorById(id);
    }

    @GetMapping
    public Collection<AuthorResponseDto> getAllAuthors(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                       @RequestParam(defaultValue = "10") @Positive int size) {
        return service.getAllAuthors(page, size);
    }
}
