package pl.bookapi.model;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MemoryBookService implements BookService {

    private static Long nextId = 4L;

    private final List<Book> bookList = new ArrayList<>();

    public MemoryBookService() {
        Author author = new Author("Bruce", "Eckel", LocalDate.of(1963, 4, 5));

        bookList.add(new Book(1L, "9788324631766", "Thiniking in Java", new Author("Bruce", "Eckel", LocalDate.of(1963, 5, 4)), "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz glowa Java.", new Author("Kathy", "Sierra", LocalDate.of(1963, 06, 05)), "Helion", "programming"));
        bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", new Author("Gary", "Horstman", LocalDate.of(1939, 1, 5)), "Helion", "programming"));
    }

    @Override
    public List<Book> getAllBooks() {
        return bookList;
    }

    @Override
    public Book getOneBook(Long id) {
        boolean exits = false;

        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                exits = true;
                return book;
            }
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "nie ma takiej książki");
    }

    @Override
    public void removeBook(Long id) {
        this.bookList.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void addBook(Book book) {
        book.setId(nextId);
        nextId++;
        this.bookList.add(book);
    }

    @Override
    public void updateBook(Book book) {
        for (Book book1 : this.bookList) {
            if (book1.getId().equals(book.getId())) {
                book1.setIsbn(book.getIsbn());
                book1.setTitle(book.getTitle());
                book1.setAuthor(book.getAuthor());
                book1.setPublisher(book.getPublisher());
                book1.setType(book.getType());
            }
        }
    }
}
