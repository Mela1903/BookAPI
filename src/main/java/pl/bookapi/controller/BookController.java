package pl.bookapi.controller;

import org.springframework.web.bind.annotation.*;
import pl.bookapi.model.Book;
import pl.bookapi.model.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    final MemoryBookService mbs = new MemoryBookService();

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return mbs.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getOneBook(@PathVariable Long id){
        return mbs.getOneBook(id);
    }

    @PostMapping("")
    public void addBook(@RequestBody Book book){
        mbs.addBook(book);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book){
        mbs.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        mbs.removeBook(id);
    }

}
