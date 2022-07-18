package com.alkemy.disney.service;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.DTO.MovieDTO;

import java.util.List;
import java.util.Set;

public interface MovieService {

    MovieDTO addMovie(MovieDTO dto);
    List<MovieDTO> getAllMovies();
    MovieDTO getMovieDetailsById(Long id);
    List<MovieDTO> getCharactersByFilters(String title, List<Long> movies, String order);
    MovieDTO updateMovie(Long id, MovieDTO movie);
    void deleteMovie(Long id);
    void addCharacterToMovie(Long movieId, Long characterId);
    void deleteCharacterFromMovie(Long movieId, Long characterId);

}
