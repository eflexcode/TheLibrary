package com.larrex.thelibrary.book.controller;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookModel;
import com.larrex.thelibrary.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestBody BookModel bookModel) {
        return bookService.addBook(bookModel);
    }

}
