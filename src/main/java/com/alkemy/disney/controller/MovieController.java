
package com.alkemy.disney.controller;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.MovieBasicDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/movies")
@Api( tags = "Movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

/*    //List All Movies
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok().body(movies);
    }*/

    @ApiOperation(value = "This method is used to add a Movie.")
    @PostMapping
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO){
        MovieDTO movieSaved = this.movieService.addMovie(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieSaved);
    }

    @ApiOperation(value = "This method is used to remove a Movie.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "This method is used to update a Movie.")
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long id, @RequestBody MovieDTO movie) {
        MovieDTO result = movieService.updateMovie(id, movie);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "This method is used to get a Movie by Id or all Movies.")
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMoviesDetailsById(@PathVariable Long id) {
        MovieDTO movieDTO = movieService.getMovieDetailsById(id);
        return ResponseEntity.ok(movieDTO);
    }

    @ApiOperation(value = "This method is used to filter Movie.")
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

    @ApiOperation(value = "This method is used to add a Character to Movie.")
    @PostMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> addCharacterToMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.addCharacterToMovie(movieId, characterId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "This method is used to remove a Character from Movie.")
    @DeleteMapping("/{movieId}/character/{characterId}")
    public ResponseEntity<Void> removeCharacterFromMovie(@PathVariable Long movieId, @PathVariable Long characterId) {
        movieService.deleteCharacterFromMovie(movieId, characterId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}

