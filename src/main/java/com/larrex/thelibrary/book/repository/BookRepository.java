package com.larrex.thelibrary.book.repository;

import com.larrex.thelibrary.book.entity.Author;
import com.larrex.thelibrary.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Page<Book> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Page<Book> findByCategoryContainingIgnoreCase(String category, Pageable pageable);
    Page<Book> findByAuthorId(Long authorId, Pageable pageable);
}
