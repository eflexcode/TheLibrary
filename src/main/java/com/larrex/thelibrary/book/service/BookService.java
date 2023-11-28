package com.larrex.thelibrary.book.service;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookModel;

import java.util.List;

public interface BookService {

    Book addBook(BookModel bookModel);

    Book updateBook(BookModel bookModel,Long id);

    Book getBookById(Long id);

    List<Book> getBookByName(String name);

    List<Book> getBooksByAuthor(Long authorId);

    List<Book> getByCategory(String category);

}
