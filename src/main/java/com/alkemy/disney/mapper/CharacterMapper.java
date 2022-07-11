package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    ModelMapper modelMapper = new ModelMapper();

    public CharacterEntity characterDTO2Entity (CharacterDTO dto){
        return modelMapper.map(dto, CharacterEntity.class);
    }

    public CharacterDTO characterEntity2DTO (CharacterEntity entity){
        CharacterDTO dto = new CharacterDTO();
        dto = modelMapper.map(entity, CharacterDTO.class);
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList (List<CharacterEntity> entities){
        List<CharacterDTO> dtos = new ArrayList<>();
        for ( CharacterEntity entity : entities ){
            dtos.add(this.characterEntity2DTO(entity));
        }
        return dtos;
    }

    public List<CharacterEntity> characterDTOList2EntityList (List<CharacterDTO> dtos){
        List<CharacterEntity> entities = new ArrayList<>();
        for ( CharacterDTO dto : dtos ){
            entities.add(this.characterDTO2Entity(dto));
        }
        return entities;
    }

    public CharacterEntity updateEntity(CharacterEntity entity, CharacterDTO dto){
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

}
