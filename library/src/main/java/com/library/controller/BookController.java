package com.library.controller;

import com.library.dto.BookDto;
import com.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book/{genresID}")
        ResponseEntity<BookDto> createBook( @RequestBody BookDto bookDto, @PathVariable Integer genresID){

        BookDto bookDto1 = this.bookService.createBook(bookDto, genresID);

        return new ResponseEntity<BookDto>(bookDto1, HttpStatus.CREATED);

    }

    @PutMapping("book/{bookId}")
    ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto, @PathVariable Integer bookId ){

        BookDto updateBook = this.bookService.updateBooks(bookDto,bookId);

        return new ResponseEntity<BookDto>(updateBook,HttpStatus.OK);
    }


    @GetMapping("/books/genres/{genresID}")
    ResponseEntity<List<BookDto>> getBooksByGenres(@PathVariable Integer genresID ){

        List<BookDto> books = this.bookService.getBooksByGenres(genresID);

        return ResponseEntity.ok(books);

    }
    @GetMapping("/book/id/{bookId}")
    ResponseEntity<BookDto> getBookById(@PathVariable Integer bookId){
        BookDto bookDto = this.bookService.getBookByID(bookId);
        return new ResponseEntity<BookDto>(bookDto,HttpStatus.OK);


    }

}
