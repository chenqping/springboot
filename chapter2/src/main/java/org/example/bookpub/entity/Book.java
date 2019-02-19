package org.example.bookpub.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private String description;

    @ManyToOne
    private Author author;
    @ManyToOne
    private Publisher publisher;
    @ManyToMany
    private List<Reviewer> reviewers;

    protected Book() {}

    public Book(String isbn, String title, Author author, Publisher publisher){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }
}
