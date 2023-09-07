package com.library.service.impl;

import com.library.dto.GenresDto;
import com.library.entities.Genres;
import com.library.repositories.GenresRepo;
import com.library.service.GenresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenresServiceImp implements GenresService {


    @Autowired
    GenresRepo genresRepo;

    @Override
    public GenresDto createGenres(GenresDto genresDto) {

        Genres genres = this.dtoToGenres(genresDto);
        Genres savedGenres = this.genresRepo.save(genres);

        return this.genresToDto(savedGenres);
    }

    @Override
    public List<GenresDto> getAllGenres() {

        List<Genres> aLLGenres = this.genresRepo.findAll();

        List<GenresDto> allGenresDto = aLLGenres.stream().map(genres -> this.genresToDto(genres)).collect(Collectors.toList());

        return allGenresDto;

    }

    public GenresDto genresToDto(Genres genres) {
        GenresDto genresDto = new GenresDto();

        genresDto.setGenresId(genres.getGenresId());
        genresDto.setGenresName(genres.getGenresName());
        genresDto.setDescription(genres.getDescription());

        return genresDto;
    }

    public Genres dtoToGenres(GenresDto genresDto) {
        Genres genres = new Genres();
        genres.setGenresName(genresDto.getGenresName());
        genres.setGenresId(genresDto.getGenresId());
        genres.setDescription(genresDto.getDescription());
        return genres;
    }
}
