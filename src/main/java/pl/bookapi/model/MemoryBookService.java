package pl.bookapi.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {

    private final List<Book> books = new ArrayList<>();

    public List<Book> getAllBooks() {
        return books;
    }

    public Book getOneBook(Long id) {
        for (Book book : books) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(Long id) {
        this.books.removeIf(book -> book.getId().equals(id));
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void updateBook(Book book) {
        for (Book book1 : this.books) {
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
