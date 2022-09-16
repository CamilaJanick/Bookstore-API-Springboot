package com.github.camilajanick.delivery.config;

import com.github.camilajanick.delivery.entities.Book;
import com.github.camilajanick.delivery.entities.enums.ReadingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.github.camilajanick.delivery.repositories.BookRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            Book book = new Book(null, "Filoteia", "São Francisco de Sales", "Espiritual", 505, 115, ReadingStatus.READING, true);
            bookRepository.save(book);
        } catch (Exception e) {
            throw new Exception("Algo está errado");
        }
    }
}