package com.larrex.thelibrary.book.service;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookModel;
import com.larrex.thelibrary.book.entity.model.BookWrapper;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    Book addBook(BookModel bookModel,Long authorId);

    Book updateBook(BookModel bookModel,Long id);

    BookWrapper getBookById(Long id);

    List<BookWrapper> getBooksByName(String name,Pageable pageable);

    List<BookWrapper> getBooksByAuthor(Long authorId,Pageable pageable);

    List<BookWrapper> getByCategory(Long category, Pageable pageable);

}
