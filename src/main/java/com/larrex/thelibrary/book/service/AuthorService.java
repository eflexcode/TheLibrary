package com.larrex.thelibrary.book.service;

import com.larrex.thelibrary.book.entity.Author;
import com.larrex.thelibrary.book.entity.model.AuthorModel;

import java.util.List;

public interface AuthorService {

    Author createAuthor(AuthorModel authorModel);
    Author updateAuthor(AuthorModel authorModel,Long id);
    Author getAuthorById(Long id);
   List<Author> getAuthorsByName(String name);
    void deleteAuthor(Long id);

}
