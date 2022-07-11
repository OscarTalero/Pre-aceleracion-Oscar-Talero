package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.entity.GenderEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenderMapper {

    ModelMapper modelMapper = new ModelMapper();

    public GenderEntity genderDTO2Entity(GenderDTO dto){

        return modelMapper.map(dto, GenderEntity.class);
    }

    public GenderDTO genderEntity2DTO (GenderEntity entity){
        GenderDTO dto = new GenderDTO();
        dto = modelMapper.map(entity, GenderDTO.class);
        return dto;
    }

    public List<GenderDTO> genderEntityList2DTOList (List<GenderEntity> entities){
        List<GenderDTO> dtos = new ArrayList<>();
        for (GenderEntity entity : entities){
            dtos.add(genderEntity2DTO(entity));
        }
        return dtos;
    }

    public GenderEntity updateEntity(GenderEntity entity, GenderDTO dto){
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        return entity;
    }

}
