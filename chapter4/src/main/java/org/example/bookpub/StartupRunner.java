package org.example.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.bookpub.entity.Author;
import org.example.bookpub.entity.Book;
import org.example.bookpub.entity.Publisher;
import org.example.bookpub.repository.AuthorRepository;
import org.example.bookpub.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.example.bookpub.repository.BookRepository;

public class StartupRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private BookRepository bookRePository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void run(String... args){
//        logger.info("Number of books: " + bookRePository.count());
        Author author = new Author("Alex", "Antonov");
        author = authorRepository.save(author);
        Publisher publisher = new Publisher("Packt");
        publisher = publisherRepository.save(publisher);
        Book book = new Book("978-1-78528-415-1", "Spring Boot Recipes", author, publisher);
        bookRePository.save(book);
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run(){
        logger.info("Number of books: " + bookRePository.count());
    }
}
