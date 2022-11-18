package com.br.rodrigo.libraryapp.controllers;

import com.br.rodrigo.libraryapp.model.Book;
import com.br.rodrigo.libraryapp.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        return new ResponseEntity<List<Book>>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Book> getProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<Book>(bookService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> update(@RequestBody Book book,@PathVariable Long id) {
        bookService.update(id,book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}