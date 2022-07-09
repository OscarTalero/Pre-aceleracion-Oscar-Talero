package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.entity.GenderEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieMapper {

    public MovieEntity movieDTO2Entity (MovieDTO dto){
        MovieEntity entity = new MovieEntity();
        entity.setTitle(dto.getTitle());
        entity.setImage(dto.getImage());
        //entity.setCreationDate(dto.getCreationDate());
        entity.setCalification(dto.getCalification());
        GenderMapper genderMapper = new GenderMapper();
        GenderEntity result = genderMapper.genderDTO2Entity(dto.getGender());
        entity.setGender(result);
     //   entity.setCharacters(dto.getCharacters());
        return entity;
    }

 /*   public GenderIdDTO gender2GenderIdDTO (GenderEntity gender){
        GenderIdDTO genderIdDTO = new GenderIdDTO();
        genderIdDTO.setId(gender.getId());
        return genderIdDTO;
    }*/
    public MovieDTO movieEntity2DTO (MovieEntity entity){
        MovieDTO dto = new MovieDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        //dto.setCreationDate(entity.getCreationDate());
        dto.setCalification(entity.getCalification());
        GenderMapper genderMapper = new GenderMapper();
        GenderDTO result = genderMapper.genderEntity2DTO(entity.getGender());
        dto.setGender(result);
        dto.setGender(result);
     //   dto.setCharacters(entity.getCharacters());
        return dto;
    }

/*    public GenderNameDTO gender2GenderNameDTO (GenderEntity gender){
        GenderNameDTO genderNameDTO = new GenderNameDTO();
        genderNameDTO.setName(gender.getName());
        return genderNameDTO;
    }*/

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
