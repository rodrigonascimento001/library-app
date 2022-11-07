package com.br.rodrigo.libraryapp.service;

import com.br.rodrigo.libraryapp.exceptions.ResourceNotFoundException;
import com.br.rodrigo.libraryapp.model.Book;
import com.br.rodrigo.libraryapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository repository;

    public Book save(Book book){
        return repository.save(book);
    }

    public Book update(long id, Book book){
        return repository.save(book);
    }

    public Book findById(long id){
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found for id:" + id));
    }

    public void delete(long id){
        repository.deleteById(id);
    }

    public List<Book> findAll(){
        return repository.findAll();
    }
}
