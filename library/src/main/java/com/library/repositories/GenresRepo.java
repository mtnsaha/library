package com.library.repositories;

import com.library.entities.Genres;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenresRepo extends JpaRepository<Genres,Integer> {
}
