package com.library.service.impl;

import com.library.dto.BookDto;
import com.library.dto.GenresDto;
import com.library.entities.Book;
import com.library.entities.Genres;
import com.library.exception.ResourceNotFoundException;
import com.library.repositories.BookRepo;
import com.library.repositories.GenresRepo;
import com.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImp implements BookService {

    @Autowired
    BookRepo bookRepo;
    @Autowired
    GenresRepo genresRepo;
    @Autowired
    GenresServiceImp genresServiceImp;


    @Override
    public BookDto createBook(BookDto bookDto, Integer genresId) {

        Genres genres = this.genresRepo.getReferenceById(genresId);
        GenresDto genresDto =genresServiceImp.genresToDto(genres);
        bookDto.setGenresDto(genresDto);

        Book book = this.dtoToBook(bookDto);
        book.setGenres(genres);

        Book savedBook = this.bookRepo.save(book);

        BookDto bookDto1=this.bookToDto(savedBook);
        bookDto1.setGenresDto(genresDto);
        return bookDto1;
    }

    @Override
    public BookDto updateBooks(BookDto bookDto, Integer bookId) {

        Book book = this.bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("book","bookId",bookId));

        Genres genres = book.getGenres();

        GenresDto genresDto = this.genresServiceImp.genresToDto(genres);


        book.setBookName(bookDto.getBookName());
        book.setBookDetails(bookDto.getBookDetails());

        Book savedBook = this.bookRepo.save(book);

        BookDto bookDto1 = this.bookToDto(savedBook);
        bookDto1.setGenresDto(genresDto);

        return bookDto1;
    }

    @Override
    public List<BookDto> getBooksByGenres(Integer genresID) {

        Genres genres = this.genresRepo.findById(genresID).orElseThrow(()->new ResourceNotFoundException("genresID","genresID",genresID));

        List<Book> books  = this.bookRepo.findByGenres(genres);

        List<BookDto> bookDto = books.stream().map(b -> this.bookToDto(b)).collect(Collectors.toList());

        return bookDto;
    }

    @Override
    public BookDto getBookByID(Integer bookId) {
        Book book = this.bookRepo.findById(bookId).orElseThrow(()->new ResourceNotFoundException("bookId","book id",bookId));
        BookDto bookDto = this.bookToDto(book);
        return bookDto;
    }

    public Book dtoToBook(BookDto bookDto){

        Book book= new Book();
        GenresDto genresDto = bookDto.getGenresDto();
        Genres genres = this.genresServiceImp.dtoToGenres(genresDto);

        book.setBookId(bookDto.getBookId());
        book.setBookName(bookDto.getBookName());
        book.setBookDetails(bookDto.getBookDetails());
        book.setGenres(genres);

        return book;


    }

    public BookDto bookToDto(Book book){
        BookDto bookDto = new BookDto();
        Genres genres = book.getGenres();
        GenresDto genresDto = this.genresServiceImp.genresToDto(genres);

        bookDto.setBookDetails(book.getBookDetails());
        bookDto.setBookName(book.getBookName());
        bookDto.setBookId(book.getBookId());
        bookDto.setGenresDto(genresDto);

        return bookDto;

    }

}
