
package com.alkemy.disney.controller;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.MovieBasicDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

/*    //List All Movies
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }*/

    //Add new Movie
    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
        MovieDTO movieSaved = this.movieService.addMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
    }

    //Delete movie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Update movie
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movie) {
        MovieDTO result = movieService.updateMovie(id, movie);
        return ResponseEntity.ok().body(result);
    }

    //Get all movies or by Id
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMoviesDetailsById(@PathVariable Long id) {
        MovieDTO movieDTO = movieService.getMovieDetailsById(id);
        return ResponseEntity.ok(movieDTO);
    }

    //Filters
    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getMoviesDetailsByFilter(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) List<Long> genre,
            @RequestParam(required = false, defaultValue = "ASC" ) String order
    )
    {
        List<MovieBasicDTO> movies = this.movieService.getMoviesByFilters(title, genre, order);
        return ResponseEntity.ok(movies);
    }

    //POST /movies/{movieId}/character/{characterId}
    @PostMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> addCharacterToMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.addCharacterToMovie(movieId, characterId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //DELETE /movies/{genreId}/character/{characterId} (remove a character from a movie by IDs)
    @DeleteMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> removeCharacterFromMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.deleteCharacterFromMovie(movieId, characterId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

