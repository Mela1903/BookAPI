package pl.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bookapi.model.Author;
import pl.bookapi.model.Book;
import pl.bookapi.model.BookService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    final BookService bs;

    @Autowired
    public BookController(BookService bookService){
        this.bs = bookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        Author newAuthor = new Author("Bruce","Eckel", LocalDate.of(1963,5,4));
        return new Book(1L, "9788324631766", "Thinking in Java", newAuthor,"Helion", "programming");
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bs.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable Long id){
        return this.bs.getOneBook(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        bs.addBook(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book){
        bs.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bs.removeBook(id);
    }

}
