package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenderEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    CharacterMapper characterMapper;

    public MovieEntity movieDTO2Entity (MovieDTO dto){

        return modelMapper.map(dto, MovieEntity.class);
    }

    public MovieDTO movieEntity2DTO (MovieEntity entity){
        MovieDTO dto = new MovieDTO();
        dto = modelMapper.map(entity, MovieDTO.class);
        return dto;
    }

    public List<MovieDTO> movieEntityList2DTOList (List<MovieEntity> entities){
        List<MovieDTO> dtos = new ArrayList<>();
        for ( MovieEntity entity : entities ){
            dtos.add(movieEntity2DTO(entity));
        }
        return dtos;
    }

    public MovieEntity updateEntity(MovieEntity entity, MovieDTO dto){
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        //TODO: update all properties
        return entity;
    }
}
