package com.larrex.thelibrary.book.serviceImpl;

import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.model.BookModel;
import com.larrex.thelibrary.book.repository.BookRepository;
import com.larrex.thelibrary.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book addBook(BookModel bookModel) {

        Book book = new Book();
        BeanUtils.copyProperties(bookModel,book);

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(BookModel bookModel,Long id) {

        Book book = getBookById(id);
        return null;
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Not Found"));
    }

    @Override
    public List<Book> getBookByName(String name) {
        return null;
    }

    @Override
    public List<Book> getBooksByAuthor(Long authorId) {
        return null;
    }

    @Override
    public List<Book> getByCategory(String category) {
        return null;
    }
}
