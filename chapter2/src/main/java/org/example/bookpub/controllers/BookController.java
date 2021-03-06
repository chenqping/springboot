package org.example.bookpub.controllers;

import org.example.bookpub.editors.IsbnEditor;
import org.example.bookpub.entity.Book;
import org.example.bookpub.entity.Reviewer;
import org.example.bookpub.model.Isbn;
import org.example.bookpub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@Controller: This is a Spring stereotype annotation that is similar to @Bean and @Repository and
declares the annotated class as an MVC
@ResponseBody: This is a Spring MVC annotation indicating that responses from the web-requestmapped
methods constitute the entire content of the HTTP response body payload, which is typical for the
RESTful applications
@RequestMapping: This is a Spring MVC annotation indicating that requests to /books/* URL will be
routed to this controller.
* */

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Isbn isbn){
        return bookRepository.findBookByIsbn(isbn.toString());
    }

    @RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
    public List<Reviewer> getReviewers(@PathVariable("isbn") Book book){
        return book.getReviewers();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }
}
