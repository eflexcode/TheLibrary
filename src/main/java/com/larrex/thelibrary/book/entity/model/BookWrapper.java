package com.larrex.thelibrary.book.entity.model;

import com.larrex.thelibrary.book.entity.Author;
import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
public class BookWrapper {

    private Long id;

    private String name;

    private String description;

    private Author author;

    private String category;

    private Date releaseDate;

    private Date createdAt;

    private Date updatedAt;

}
