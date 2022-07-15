
package com.alkemy.disney.service.impl;

import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieMapper movieMapper;

    @Autowired
    MovieRepository movieRepository;

    //Add new Movie
    public MovieDTO addMovie (MovieDTO movieDTO){
        MovieEntity movieEntity = movieMapper.movieDTO2Entity(movieDTO);  //1
        MovieEntity entitySaved = movieRepository.save(movieEntity);
        return movieMapper.movieEntity2DTO(entitySaved, true);  //10
    }


 public List<MovieDTO> getAllMovies(){
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities, false);
        return result;
    }
 /*
    public void deleteMovie (Long id){
        movieRepository.deleteById(id);
    }

    public MovieDTO updateMovie (Long id, MovieDTO dto){
        Optional<MovieEntity> entity = movieRepository.findById(id);
        MovieEntity entityFind = entity.get();
        MovieEntity entityUpdated = movieMapper.updateEntity(entityFind, dto);
        MovieEntity entitySaved = movieRepository.save(entityUpdated);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved, false);
        return result;
    }
*/
}

