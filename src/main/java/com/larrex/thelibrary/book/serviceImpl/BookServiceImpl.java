package com.larrex.thelibrary.book.serviceImpl;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.repository.BookRepository;
import com.larrex.thelibrary.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

}
