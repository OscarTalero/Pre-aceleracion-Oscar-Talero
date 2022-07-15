package com.alkemy.disney.service;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.DTO.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO addMovie(MovieDTO dto);
   List<MovieDTO> getAllMovies();
 /*    void deleteMovie(Long id);
    MovieDTO updateMovie(Long id, MovieDTO movie);*/
}
