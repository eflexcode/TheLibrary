package com.larrex.thelibrary.book.controller;

import com.larrex.thelibrary.book.entity.Author;
import com.larrex.thelibrary.book.entity.model.AuthorModel;
import com.larrex.thelibrary.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("author/v1/")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping()
    public Author createAuthor(@RequestBody AuthorModel authorModel){
        return authorService.createAuthor(authorModel);
    }

    @PutMapping
    public Author updateAuthor(AuthorModel authorModel,Long id) {
       return authorService.updateAuthor(authorModel, id);
    }

    @GetMapping("{id}")
    public Author getAuthorById(@PathVariable(name = "id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping()
    public Author getAuthorByName(@RequestParam(name = "name") String name) {
        return authorService.getAuthorByName(name);
    }

    @DeleteMapping
    public void deleteAuthor(Long id) {
        authorService.deleteAuthor(id);
    }


}
