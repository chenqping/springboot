package com.example.bookpub.controllers;

import com.example.bookpub.editors.IsbnEditor;
import com.example.bookpub.entity.Book;
import com.example.bookpub.entity.Reviewer;
import com.example.bookpub.model.Isbn;
import com.example.bookpub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public String getSessionId(HttpServletRequest request){
        return request.getSession().getId();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
    }
}
