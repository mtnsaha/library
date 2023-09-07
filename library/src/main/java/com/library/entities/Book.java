package com.library.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer bookId;

     private String bookName;

     private String bookDetails;

     @ManyToOne
     @JoinColumn(name="genres_id")
     private Genres genres;



}
