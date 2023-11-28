package com.larrex.thelibrary.book.entity.model;

import com.larrex.thelibrary.book.entity.Author;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class BookModel {
    private String name;
    private String description;
    private String category;
    private Date releaseDate;
}
