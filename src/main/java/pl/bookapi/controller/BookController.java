package pl.bookapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.bookapi.model.Book;
import pl.bookapi.model.BookService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/admin/books", produces = "text/html; charset=UTF-8")
public class BookController {

    private final BookService bs;

    @Autowired
    public BookController(BookService bookService){
        this.bs = bookService;
    }

    @GetMapping("/all")
    public String showPosts(Model model) {
        List<Book> books = bs.getAllBooks();
        model.addAttribute("books", books);
        return "/books/all";
    }

    @GetMapping("/add")
    public String addBook(Model model){
            model.addAttribute("book", new Book());
            return "books/add";
    }

    @PostMapping("/add")
    public String saveBook(@Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "books/add";
        }
        bs.addBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Optional<Book> bookEdited = bs.getOneBook(id);
        model.addAttribute("bookEdited", bookEdited);
        model.addAttribute("book", new Book());
        return "books/edit";
    }

    @PostMapping("/edit")
    public String editPost(@ModelAttribute Book book) {
        bs.updateBook(book);
        return "redirect:/admin/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(Model model, @PathVariable long id) {
        bs.removeBook(id);
        return "redirect:/admin/books/all";

    }

    @GetMapping("/show/{id}")
    public String showBook(Model model, @PathVariable long id) {
        model.addAttribute("book", bs.getOneBook(id).orElseThrow(EntityNotFoundException::new));
        return "books/show";
    }

}
