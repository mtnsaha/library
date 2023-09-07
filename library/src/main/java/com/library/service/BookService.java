package com.library.service;

import com.library.dto.BookDto;
import com.library.entities.Book;

import java.util.List;


public interface BookService {


BookDto createBook(BookDto bookDto, Integer genresId);

BookDto updateBooks(BookDto bookDto, Integer bookId);

List<BookDto> getBooksByGenres(Integer genresID);

    BookDto getBookByID(Integer bookId);
}


