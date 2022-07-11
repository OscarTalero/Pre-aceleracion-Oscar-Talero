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

    public MovieDTO saveMovie (MovieDTO dto){
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        movieRepository.save(entity);
        MovieDTO result = movieMapper.movieEntity2DTO(entity);
        return result;
    }

    public List<MovieDTO> getAllMovies(){
        List<MovieEntity> entities = movieRepository.findAll();
        List<MovieDTO> result = movieMapper.movieEntityList2DTOList(entities);
        return result;
    }

    public void deleteMovie (Long id){
        movieRepository.deleteById(id);
    }

    public MovieDTO updateMovie (Long id, MovieDTO dto){
        Optional<MovieEntity> entity = movieRepository.findById(id);
        MovieEntity entityFind = entity.get();
        MovieEntity entityUpdated = movieMapper.updateEntity(entityFind, dto);
        MovieEntity entitySaved = movieRepository.save(entityUpdated);
        MovieDTO result = movieMapper.movieEntity2DTO(entitySaved);
        return result;
    }
}
