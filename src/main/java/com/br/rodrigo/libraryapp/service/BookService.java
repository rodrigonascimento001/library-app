package com.br.rodrigo.libraryapp.service;

import com.br.rodrigo.libraryapp.exceptions.ResourceNotFoundException;
import com.br.rodrigo.libraryapp.exceptions.UploadException;
import com.br.rodrigo.libraryapp.infra.FileSaver;
import com.br.rodrigo.libraryapp.model.Book;
import com.br.rodrigo.libraryapp.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static java.util.Objects.requireNonNull;

@Service
@RequiredArgsConstructor
public class BookService {
    @Autowired
    private BookRepository repository;

    @Autowired
    private FileSaver fileSaver;

    public Book save(Book book, String path){
        book.setPathImage(path);
        return repository.save(book);
    }

    public Book update(long id, Book book, String path){
        book.setPathImage(path);
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

    public String uploadFile(MultipartFile imgBook)  {
        try{
            validateParameters(imgBook);
            return fileSaver.write(imgBook);
        }catch (UploadException e){
            throw new UploadException("Erro ao executar upload do arquivo");
        }

    }

    public void validateParameters(MultipartFile imgBook) throws UploadException {
        if (imgBook == null ||  requireNonNull(imgBook.getOriginalFilename()).isEmpty()){
            throw new UploadException("Erro ao fazer o upload do arquivo");
        }
    }
}
