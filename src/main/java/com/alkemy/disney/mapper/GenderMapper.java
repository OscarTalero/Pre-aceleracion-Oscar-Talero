package com.alkemy.disney.mapper;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.entity.GenderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenderMapper {

    public GenderEntity genderDTO2Entity(GenderDTO dto){
        GenderEntity genderEntity = new GenderEntity();
        genderEntity.setId(dto.getId());
        genderEntity.setName(dto.getName());
        genderEntity.setImage(dto.getImage());
        return genderEntity;
    }

    public GenderDTO genderEntity2DTO (GenderEntity entity){
        GenderDTO dto = new GenderDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setImage(entity.getImage());
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
