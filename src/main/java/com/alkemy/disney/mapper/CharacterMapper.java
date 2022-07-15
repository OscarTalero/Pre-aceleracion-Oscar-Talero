
package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    ModelMapper modelMapper = new ModelMapper();
    @Lazy
    @Autowired
    private MovieMapper movieMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        return characterEntity;
    }

    public CharacterDTO characterEntity2DTO (CharacterEntity entity, boolean loadMovies){   //14
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());;
        if (loadMovies) {
            List<MovieDTO> moviesDTOList = movieMapper.movieEntityList2DTOList(entity.getMovies(), false);
            dto.setMovies(moviesDTOList);
        }
        return dto;
    }


    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtos) { //4
        List<CharacterEntity> entities = new ArrayList<>();
        for (CharacterDTO dto : dtos) {
            entities.add(this.characterDTO2Entity(dto));  //5
        }
        return entities;
    }


    public List<CharacterDTO> characterEntityList2DTOList (List<CharacterEntity> entities, boolean loadMovies){  //13
        List<CharacterDTO> dtos = new ArrayList<>();
        for ( CharacterEntity entity : entities ){
            dtos.add(this.characterEntity2DTO(entity, loadMovies));
        }
        return dtos;
    }
    
    public CharacterEntity updateEntity(CharacterEntity entity, CharacterDTO dto){
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

}
