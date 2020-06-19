package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import com.lambdaschool.foundation.models.*;
import com.lambdaschool.foundation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "bookService")
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        bookRepository.findAll()
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Transactional
    @Override
    public void delete(long id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book id " + id + " not found!"));
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book) {

        List<Wrote> author = new ArrayList<>();
        for (Wrote w : book.getWrotes())
        {
            author.add(new Wrote(w.getAuthor(), book));

        }
        book.setWrotes(author);
        return bookRepository.save(book);
    }
}
