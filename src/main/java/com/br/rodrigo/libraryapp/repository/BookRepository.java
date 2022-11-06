package com.br.rodrigo.libraryapp.repository;

import com.br.rodrigo.libraryapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}