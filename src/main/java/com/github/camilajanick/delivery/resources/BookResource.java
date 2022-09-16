package com.github.camilajanick.delivery.resources;

import com.github.camilajanick.delivery.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.github.camilajanick.delivery.repositories.BookRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookResource {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return bookRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity store(@Valid @RequestBody Book object) {
        bookRepository.save(object);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @Valid @RequestBody Book object) {
        return bookRepository.findById(id).map(record -> {
            record.setFavorite(object.getFavorite());
            record.setAuthor(object.getAuthor());
            record.setName(object.getName());
            record.setGender(object.getGender());
            record.setReadingStatus(object.getReadingStatus());
            record.setReadPages(object.getReadPages());
            record.setTotalPages(object.getTotalPages());

            return ResponseEntity.ok().body(bookRepository.save(record));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(value = "/{id}")
    public void destroy(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
