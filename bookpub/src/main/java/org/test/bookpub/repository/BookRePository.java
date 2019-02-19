package org.test.bookpub.repository;

import org.springframework.data.repository.CrudRepository;
import org.test.bookpub.entity.Book;

public interface BookRePository extends CrudRepository<Book, Long> {
    public Book findBookByIsbn(String isbn);
}
