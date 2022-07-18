
package com.alkemy.disney.service.impl;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.DTO.MovieFiltersDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.repository.Specifications.MovieSpecification;
import com.alkemy.disney.service.CharacterService;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieMapper movieMapper;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    private CharacterService characterService;
    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    private MovieSpecification movieSpecification;

    //Add new Movie
    public MovieDTO addMovie (MovieDTO movieDTO){
        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO);  //1
        MovieEntity entitySaved = movieRepository.save(movieEntity);
        return movieMapper.movieEntity2DTO(entitySaved, true);  //10
    }

    //Get All movies
    public List<MovieDTO> getAllMovies(){
            List<MovieEntity> entities = movieRepository.findAll();
            return movieMapper.movieEntityList2DTOList(entities, false);
        }

    //Get especific movie
    public MovieDTO getMovieDetailsById(Long id) {
        Optional<MovieEntity> movieEntity = movieRepository.findById(id);
        if (!movieEntity.isPresent()) {
            throw new ParamNotFound("Movie ID not valid.");
        }
        return movieMapper.movieEntity2DTO(movieEntity.get(), true);
    }

    //Update movie
    public MovieDTO updateMovie (Long id, MovieDTO dto){
        Optional<MovieEntity> entity = movieRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Movie ID not valid.");
        }
        MovieEntity entityFind = entity.get();
        MovieEntity entityUpdated = movieMapper.updateEntity(entityFind, dto);
        MovieEntity entitySaved = movieRepository.save(entityUpdated);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved, false);
        return result;
    }

    //Delete movie
    public void deleteMovie (Long id){
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new ParamNotFound("Movie ID not exists in Database");
        }
    }

    //Filters
     public List<MovieDTO> getCharactersByFilters (String title, List<Long> genre, String order) {
            MovieFiltersDTO filtersDTO = new MovieFiltersDTO(title, genre, order);
            List<MovieEntity> entityList = movieRepository.findAll(movieSpecification.getMoviesByFilters(filtersDTO));
            return movieMapper.movieEntityList2DTOList(entityList, true);
        }

    public void addCharacterToMovie(Long movieId, Long characterId) {
        MovieDTO movieDTO = this.getMovieDetailsById(movieId);
        MovieEntity movie = movieMapper.movieDTO2Entity(movieDTO);
        movie.getCharacters().size();
        CharacterDTO characterDTO = characterService.getCharacterDetailsById(characterId);
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO);
        movie.addCharacterToMovie(characterEntity);
        movieRepository.save(movie);
    }

    public void deleteCharacterFromMovie(Long movieId, Long characterId) {
        MovieDTO movieDTO = this.getMovieDetailsById(movieId);
        MovieEntity movie = movieMapper.movieDTO2Entity(movieDTO);
        movie.getCharacters().size();
        CharacterDTO characterDTO = characterService.getCharacterDetailsById(characterId);
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(characterDTO);
        movie.removeCharacterFromMovie(characterEntity);
        movieRepository.save(movie);

    }
}

