package com.larrex.thelibrary.book.controller;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookModel;
import com.larrex.thelibrary.book.entity.model.BookWrapper;
import com.larrex.thelibrary.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book/v1")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/add")
    public Book addBook(@RequestParam(name = "author_id") Long authorId, @RequestBody BookModel bookModel) {
        return bookService.addBook(bookModel,authorId);
    }

    @GetMapping("{id}")
    public BookWrapper getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody BookModel bookModel){
        return bookService.updateBook(bookModel,id);
    }

    @GetMapping()
   public List<BookWrapper> getBooksByName(@RequestParam(name = "name") String name, Pageable pageable) {
     return bookService.getBooksByName(name, pageable);
    }

}
