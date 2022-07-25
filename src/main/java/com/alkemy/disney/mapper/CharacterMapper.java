package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.CharacterBasicDTO;
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

    //Convert character DTO to Entity
    public CharacterEntity characterDTO2Entity(CharacterDTO dto) {
        CharacterEntity characterEntity = new CharacterEntity();
        characterEntity.setImage(dto.getImage());
        characterEntity.setName(dto.getName());
        characterEntity.setAge(dto.getAge());
        characterEntity.setWeight(dto.getWeight());
        characterEntity.setHistory(dto.getHistory());
        return characterEntity;
    }

    //Convert character Entity to DTO
    public CharacterDTO characterEntity2DTO (CharacterEntity entity, boolean loadMovies){   //14
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());;
        if (loadMovies) {
            List<MovieDTO> moviesDTOList = this.movieMapper.movieEntityList2DTOList(entity.getMovies(), false);
            dto.setMovies(moviesDTOList);
        }
        return dto;
    }

    public CharacterBasicDTO characterEntity2DTOBasic (CharacterEntity entity){   //14
        CharacterBasicDTO dto = new CharacterBasicDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

    //Convert character List DTO to  List Entity
    public List<CharacterEntity> characterDTOList2EntityList(List<CharacterDTO> dtos) { //4
        List<CharacterEntity> entities = new ArrayList<>();
        for (CharacterDTO dto : dtos) {
            entities.add(this.characterDTO2Entity(dto));  //5
        }
        return entities;
    }

    //Convert character List Entity to  List DTO
    public List<CharacterDTO> characterEntityList2DTOList (List<CharacterEntity> entities, boolean loadMovies){  //13
        List<CharacterDTO> dtos = new ArrayList<>();
        for ( CharacterEntity entity : entities ){
            dtos.add(this.characterEntity2DTO(entity, true));
        }
        return dtos;
    }

    //Convert character List Entity to  List DTO Basic
    public List<CharacterBasicDTO> characterEntityList2DTOBasicList (List<CharacterEntity> entities){  //13
        List<CharacterBasicDTO> dtos = new ArrayList<>();
        for ( CharacterEntity entity : entities ){
            dtos.add(this.characterEntity2DTOBasic(entity));
        }
        return dtos;
    }

    //Update character entity
    public CharacterEntity updateEntity(CharacterEntity entity, CharacterDTO dto){
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());;
        return entity;
    }
}
