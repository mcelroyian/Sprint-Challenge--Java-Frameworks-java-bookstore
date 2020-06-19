package com.lambdaschool.foundation.services;

import com.lambdaschool.foundation.FoundationApplication;
import com.lambdaschool.foundation.exceptions.ResourceNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FoundationApplication.class)
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {

//        System.out.println(bookService.findAll().get(0).getBookid());
//        System.out.println(bookService.findAll().get(1).getBookid());
//        System.out.println(bookService.findAll().get(2).getBookid());
//        System.out.println(bookService.findAll().get(3).getBookid());
        assertEquals(5, bookService.findAll().size());
    }

    @Test
    public void delete() {
    bookService.delete(76);
    assertEquals(4, bookService.findAll().size());
    }

    @Test
    public void save() {
    }
}