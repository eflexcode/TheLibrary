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

    @PutMapping("{id}")
    public Author updateAuthor(@PathVariable(name = "id")Long id,@RequestBody AuthorModel authorModel) {
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

    @DeleteMapping("{id}")
    public void deleteAuthor(@PathVariable(name = "id")Long id) {
        authorService.deleteAuthor(id);
    }


}
