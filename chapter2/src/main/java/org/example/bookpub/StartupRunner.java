package org.example.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.example.bookpub.repository.BookRepository;

public class StartupRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private BookRepository bookRePository;

    @Override
    public void run(String... args){
        logger.info("Number of books: " + bookRePository.count());
    }

    @Scheduled(initialDelay = 1000, fixedRate = 10000)
    public void run(){
        logger.info("Number of books: " + bookRePository.count());
    }
}
