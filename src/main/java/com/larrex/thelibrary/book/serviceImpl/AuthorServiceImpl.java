package com.larrex.thelibrary.book.serviceImpl;

import com.larrex.thelibrary.book.entity.Author;
import com.larrex.thelibrary.book.entity.model.AuthorModel;
import com.larrex.thelibrary.book.repository.AuthorRepository;
import com.larrex.thelibrary.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(AuthorModel authorModel) {

        Author author = new Author();
        BeanUtils.copyProperties(authorModel,author);

        return authorRepository.save(author);
    }

    @Override
    public Author updateAuthor(AuthorModel authorModel,Long id) {
        Author author =  authorRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No author found"));

        author.setName(authorModel.getName() != null ? authorModel.getName() : author.getName());
        author.setAge(authorModel.getAge() != null ? authorModel.getAge() : author.getAge());
        author.setDescription(authorModel.getDescription() != null ? authorModel.getDescription() : author.getDescription());
        System.out.println("fffffffffffffffffffff"+authorModel);
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No author found"));
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        return authorRepository.findByNameContainingIgnoreCase(name);//.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No author found"));
    }

    @Override
    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No author found"));
        authorRepository.delete(author);
    }

}
