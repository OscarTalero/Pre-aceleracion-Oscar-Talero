package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenderEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity (MovieDTO dto){
        MovieEntity entity = new MovieEntity();
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        //entity.setCreationDate(dto.getCreationDate());
        entity.setRating(dto.getRating());
        GenderMapper genderMapper = new GenderMapper();
        GenderEntity resultGender = genderMapper.genderDTO2Entity(dto.getGender());
        entity.setGender(resultGender);
 //       entity.setCharacters(dto.getCharacters());
        return entity;
    }

    public MovieDTO movieEntity2DTO (MovieEntity entity){
        MovieDTO dto = new MovieDTO();
     //   dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        //dto.setCreationDate(entity.getCreationDate());
        dto.setRating(entity.getRating());
        GenderMapper genderMapper = new GenderMapper();
        GenderDTO result = genderMapper.genderEntity2DTO(entity.getGender());
        dto.setGender(result);
        dto.setGender(result);
      //  dto.setCharacters(entity.getCharacters());
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
