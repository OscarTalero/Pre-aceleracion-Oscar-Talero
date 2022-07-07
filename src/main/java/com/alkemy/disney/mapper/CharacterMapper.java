package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterEntity characterDTO2Entity (CharacterDTO dto){
        CharacterEntity entity = new CharacterEntity();
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setAge(dto.getAge());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
        entity.setMovies(dto.getMovies());
        return entity;
    }

    public CharacterDTO characterEntity2DTO (CharacterEntity entity){
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
        dto.setAge(entity.getAge());
        dto.setWeight(entity.getWeight());
        dto.setHistory(entity.getHistory());
        dto.setMovies(entity.getMovies());
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList (List<CharacterEntity> entities){
        List<CharacterDTO> dtos = new ArrayList<>();
        for ( CharacterEntity entity : entities ){
            dtos.add(characterEntity2DTO(entity));
        }
        return dtos;
    }

    public CharacterEntity updateEntity(CharacterEntity entity, CharacterDTO dto){
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }
}
