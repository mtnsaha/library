package com.library.controller;


import com.library.dto.GenresDto;
import com.library.service.GenresService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenresController {

    @Autowired
    GenresService genresService;
@PostMapping("/genres")
    ResponseEntity<GenresDto> createGenres(@Valid @RequestBody GenresDto genresDto){

        GenresDto book1 = this.genresService.createGenres(genresDto);

        return new ResponseEntity<GenresDto>(book1, HttpStatus.CREATED);

    }

    @GetMapping("/genres")
    ResponseEntity<List<GenresDto>> getGenres(){

        List<GenresDto> allGenres = this.genresService.getAllGenres();

        return ResponseEntity.ok(allGenres);

}


}
