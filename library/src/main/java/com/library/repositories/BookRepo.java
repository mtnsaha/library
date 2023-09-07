package com.library.repositories;

import com.library.dto.BookDto;
import com.library.entities.Book;
import com.library.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {

    List<Book> findByGenres(Genres genres);


}
