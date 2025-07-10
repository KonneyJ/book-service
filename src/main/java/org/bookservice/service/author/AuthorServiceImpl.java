package org.bookservice.service.author;

import lombok.RequiredArgsConstructor;
import org.bookservice.dto.author.AuthorRequestDto;
import org.bookservice.dto.author.AuthorResponseDto;
import org.bookservice.exception.ConflictException;
import org.bookservice.exception.NotFoundException;
import org.bookservice.mapper.author.AuthorMapper;
import org.bookservice.model.author.Author;
import org.bookservice.repository.author.AuthorRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    @Override
    public AuthorResponseDto createAuthor(AuthorRequestDto newAuthor) {
        if (repository.findByName(newAuthor.getName()) != null) {
            throw new ConflictException("Автор с именем: " + newAuthor.getName() + " уже существует. " +
                    "Добавление невозможно");
        }
        Author author = repository.save(mapper.toAuthor(newAuthor));
        return mapper.toAuthorDto(author);
    }

    @Override
    public AuthorResponseDto getAuthorById(Long id) {
        Author author = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Автор с id = " + id + " не найден"));
        return mapper.toAuthorDto(author);
    }

    @Override
    public Collection<AuthorResponseDto> getAllAuthors(int page, int size) {
        PageRequest pages = PageRequest.of(page, size, Sort.by("id").ascending());
        List<Author> authors = new ArrayList<>();
        authors = repository.findAll(pages).getContent();
        return authors.stream()
                .map(AuthorMapper::toAuthorDto)
                .collect(Collectors.toList());
    }
}
