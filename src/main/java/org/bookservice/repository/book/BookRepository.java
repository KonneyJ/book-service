package org.bookservice.repository.book;

import org.bookservice.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitleAndAuthorId(String title, Long authorId);
}
