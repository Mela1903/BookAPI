package pl.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bookapi.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

