package org.example.bookpub.repository;

import org.springframework.data.repository.CrudRepository;
import org.example.bookpub.entity.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    public Book findBookByIsbn(String isbn);
}
