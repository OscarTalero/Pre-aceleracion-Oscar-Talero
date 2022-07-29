package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;

import java.util.List;

public interface MovieService {

    MovieDTO addMovie(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieDetailsById(Long id);
    List<MovieBasicDTO> getMoviesByFilters(String title, List<Long> movies, String order);
    MovieDTO updateMovie(Long id, MovieDTO movie);
    void deleteMovie(Long id);
    void addCharacterToMovie(Long movieId, Long characterId);
    void deleteCharacterFromMovie(Long movieId, Long characterId);
}
