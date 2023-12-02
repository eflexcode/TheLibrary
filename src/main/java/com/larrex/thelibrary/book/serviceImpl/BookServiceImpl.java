package com.larrex.thelibrary.book.serviceImpl;

import com.larrex.thelibrary.book.entity.Author;
import com.larrex.thelibrary.book.entity.Book;
import com.larrex.thelibrary.book.entity.Category;
import com.larrex.thelibrary.book.entity.model.BookModel;
import com.larrex.thelibrary.book.entity.model.BookWrapper;
import com.larrex.thelibrary.book.repository.AuthorRepository;
import com.larrex.thelibrary.book.repository.BookRepository;
import com.larrex.thelibrary.book.service.AuthorService;
import com.larrex.thelibrary.book.service.BookService;
import com.larrex.thelibrary.book.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.ASTNode;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    @Override
    public Book addBook(BookModel bookModel, Long authorId) {

        Book book = new Book();
        BeanUtils.copyProperties(bookModel, book);
        Author author = authorService.getAuthorById(authorId);
        Category category = categoryService.getCategory(bookModel.getCategoryId());
        book.setAuthorId(authorId);
        return bookRepository.save(book);

    }

    @Override
    public Book updateBook(BookModel bookModel, Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        book.setName(bookModel.getName() != null ? bookModel.getName() : book.getName());
        book.setCategoryId(bookModel.getCategoryId() != null ? bookModel.getCategoryId(): book.getCategoryId());
        book.setDescription(bookModel.getDescription() != null ? bookModel.getDescription(): book.getDescription());
        book.setReleaseDate(bookModel.getReleaseDate() != null ? bookModel.getReleaseDate(): book.getReleaseDate());
        return bookRepository.save(book);
    }

    @Override
    public BookWrapper getBookById(Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found"));
        Author author = authorService.getAuthorById(book.getAuthorId());
        Category category = categoryService.getCategory(book.getCategoryId());
        BookWrapper bookWrapper = new BookWrapper();
        BeanUtils.copyProperties(book, bookWrapper);
        bookWrapper.setAuthor(author);
        bookWrapper.setCategory(category.getCategoryName());
        return bookWrapper;
    }

    @Override
    public List<BookWrapper> getBooksByName(String name, Pageable pageable) {

        Page<Book> book = bookRepository.findByNameContainingIgnoreCase(name,pageable);
        List<BookWrapper> bookWrappers = new ArrayList<>();

        for (Book newBook : book) {

            BookWrapper bookWrapper = new BookWrapper();
            BeanUtils.copyProperties(newBook, bookWrapper);

            Author author = authorService.getAuthorById(newBook.getAuthorId());
            bookWrapper.setAuthor(author);
            Category category = categoryService.getCategory(newBook.getCategoryId());

            bookWrapper.setCategory(category.getCategoryName());
            bookWrappers.add(bookWrapper);
        }

        return bookWrappers;
    }

    @Override
    public List<BookWrapper> getBooksByAuthor(Long authorId,Pageable pageable) {

        Page<Book> book = bookRepository.findByAuthorId(authorId,pageable);

        List<BookWrapper> bookWrappers = new ArrayList<>();

        for (Book newBook : book) {

            BookWrapper bookWrapper = new BookWrapper();
            BeanUtils.copyProperties(newBook, bookWrapper);

            Author author = authorService.getAuthorById(newBook.getAuthorId());
            bookWrapper.setAuthor(author);
            bookWrappers.add(bookWrapper);
        }

        return bookWrappers;
    }

    @Override
    public List<BookWrapper> getByCategory(String category,Pageable pageable) {

        Page<Book> book = bookRepository.findByCategoryContainingIgnoreCase(category,pageable);

        List<BookWrapper> bookWrappers = new ArrayList<>();

        for (Book newBook : book) {

            BookWrapper bookWrapper = new BookWrapper();
            BeanUtils.copyProperties(newBook, bookWrapper);

            Author author = authorService.getAuthorById(newBook.getAuthorId());
            bookWrapper.setAuthor(author);
            bookWrappers.add(bookWrapper);
        }

        return bookWrappers;
    }
}
