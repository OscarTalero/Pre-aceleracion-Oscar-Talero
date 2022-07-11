package com.alkemy.disney.service;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.DTO.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO save(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    void delete(Long id);
    MovieDTO update(Long id, MovieDTO movie);
}
