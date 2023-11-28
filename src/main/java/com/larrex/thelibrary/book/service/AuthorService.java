package com.larrex.thelibrary.book.service;

import com.larrex.thelibrary.book.entity.Author;
import com.larrex.thelibrary.book.entity.model.AuthorModel;

public interface AuthorService {

    Author createAuthor(AuthorModel authorModel);

}
