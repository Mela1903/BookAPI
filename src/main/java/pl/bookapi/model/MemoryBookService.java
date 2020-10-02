package pl.bookapi.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryBookService {

    private static Long nextId = 4L;

    private final List<Book> bookList = new ArrayList<>();
    public MemoryBookService(){
        bookList.add(new Book(1L, "9788324631766", "Thiniking in Java", "Bruce Eckel", "Helion", "programming"));
        bookList.add(new Book(2L, "9788324627738", "Rusz glowa Java.", "Sierra Kathy, Bates Bert", "Helion","programming"));
        bookList.add(new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion","programming"));
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getOneBook(Long id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void removeBook(Long id) {
        this.bookList.removeIf(book -> book.getId().equals(id));
    }

    public void addBook(Book book) {
        book.setId(nextId);
        nextId++;
        this.bookList.add(book);
    }

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
