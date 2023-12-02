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
        return bookService.addBook(bookModel, authorId);
    }

    @GetMapping("{id}")
    public BookWrapper getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody BookModel bookModel) {
        return bookService.updateBook(bookModel, id);
    }

    //please on query at a time
    @GetMapping("/query")
    public List<BookWrapper> getBooksByName(@RequestParam(name = "name",required = false) String name, @RequestParam(name = "category",required = false) Long category, @RequestParam(name = "author_id",required = false) Long id, Pageable pageable) {

        if (name != null) {
            return bookService.getBooksByName(name, pageable);
        }else if (category != null){
            return bookService.getByCategory(category, pageable);
        }else {
           return bookService.getBooksByAuthor(id, pageable);
        }
    }

//    @GetMapping()
//    public List<BookWrapper> getBooksByCategory(@RequestParam(name = "category") String category, Pageable pageable){
//        return bookService.getByCategory(category, pageable);
//    }
//
//    @GetMapping("/")
//    public List<BookWrapper> getBooksByAuthor(@RequestParam(name = "author_id") Long id, Pageable pageable){
//        return bookService.getBooksByAuthor(id, pageable);
//    }
//

}
