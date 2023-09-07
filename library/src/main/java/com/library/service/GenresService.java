package com.library.service;

import com.library.dto.BookDto;
import com.library.dto.GenresDto;

import java.util.List;

public interface GenresService {


    GenresDto createGenres(GenresDto bookDto);

    List<GenresDto> getAllGenres();
}
