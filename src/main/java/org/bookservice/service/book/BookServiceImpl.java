package org.bookservice.service.book;

import lombok.RequiredArgsConstructor;
import org.bookservice.dto.book.BookRequestDto;
import org.bookservice.dto.book.BookResponseDto;
import org.bookservice.dto.book.BookShortResponseDto;
import org.bookservice.exception.ConflictException;
import org.bookservice.exception.NotFoundException;
import org.bookservice.mapper.book.BookMapper;
import org.bookservice.model.author.Author;
import org.bookservice.model.book.Book;
import org.bookservice.repository.author.AuthorRepository;
import org.bookservice.repository.book.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository repository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDto createBook(BookRequestDto newBook) {
        Author author = checkAuthorExist(newBook.getAuthorId());
        if (repository.findByTitleAndAuthorId(newBook.getTitle(), author.getId()) != null) {
            throw new ConflictException("Книга с названием: " + newBook.getTitle() + " автора с именем: " +
                    author.getName() + " уже существует. Добавление невозможно");
        }
        Book book = repository.save(bookMapper.toBook(newBook));
        return bookMapper.toBookDto(book, author);
    }

    @Override
    public Collection<BookShortResponseDto> getAllBooks() {
        List<Book> books = new ArrayList<>();
        books = repository.findAll();
        return books.stream()
                .map(BookMapper::toBookShortDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Book book = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Книга с id = " + id + " не найдена"));
        Author author = checkAuthorExist(book.getAuthorId());
        return bookMapper.toBookDto(book, author);
    }

    @Override
    public BookResponseDto updateBook(Long id, BookRequestDto bookToUpdate) {
        Book book = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Книга с id = " + id + " не найдена"));
        Author author = checkAuthorExist(bookToUpdate.getAuthorId());
        Book bookToSave = bookMapper.toBook(bookToUpdate);
        bookToSave.setId(book.getId());
        Book updatedBook = repository.save(bookToSave);
        return bookMapper.toBookDto(updatedBook, author);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = repository.findById(id).orElseThrow(
                () -> new NotFoundException("Книга с id = " + id + " не найдена"));
        repository.deleteById(id);
    }

    private Author checkAuthorExist(Long id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Автор с id = " + id + " не найден"));
    }
}
