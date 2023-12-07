package com.larrex.thelibrary.loan.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "load")
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "liberian_id")
    private Long liberianId;

    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_address")
    private String studentAddress;
    @Column(name = "student_image")
    private String studentImage;
    @Column(name = "student_class_number")
    private Long studentClassNumber;

    @Column(name = "created_at",updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Date updatedAt;

}
