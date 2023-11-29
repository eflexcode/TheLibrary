package com.larrex.thelibrary.book.controller;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookModel;
import com.larrex.thelibrary.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestParam(name = "author_id") Long authorId, @RequestBody BookModel bookModel) {
        return bookService.addBook(bookModel,authorId);
    }

}
