package pl.bookapi.model;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getOneBook(Long id);

    void addBook(Book book);

    void removeBook(Long id);

    void updateBook(Book book);
}
