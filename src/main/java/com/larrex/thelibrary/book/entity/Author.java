package com.larrex.thelibrary.book.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="text")
    private String name;

    private Integer age;

    @Column(columnDefinition="text")
    private String description;

//    @JsonIgnore
//    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
//    private List<Book> books;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;
}
