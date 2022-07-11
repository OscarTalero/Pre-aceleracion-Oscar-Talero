package com.alkemy.disney.service.impl;

import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.entity.GenderEntity;
import com.alkemy.disney.mapper.GenderMapper;
import com.alkemy.disney.repository.GenderRepository;
import com.alkemy.disney.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderServiceImpl implements GenderService {

    @Autowired
    private GenderMapper genderMapper;
    @Autowired
    private GenderRepository genderRepository;

    public GenderDTO addGender(GenderDTO dto){
        GenderEntity entity = genderMapper.genderDTO2Entity(dto);
        genderRepository.save(entity);
        GenderDTO result = genderMapper.genderEntity2DTO(entity);
        return result;
    }

    public List<GenderDTO> getAllGenders() {
        List<GenderEntity> entities = genderRepository.findAll();
        List<GenderDTO> result = genderMapper.genderEntityList2DTOList(entities);
        return result;
    }

    public void deleteGender(Long id) {
        genderRepository.deleteById(id);
    }

    public GenderDTO updateGender(Long id, GenderDTO dto){
        Optional<GenderEntity> entity = genderRepository.findById(id);
        GenderEntity entityFind = entity.get();
        GenderEntity entityUpdated = genderMapper.updateEntity(entityFind, dto);
        GenderEntity entitySaved = genderRepository.save(entityUpdated);
        GenderDTO result = genderMapper.genderEntity2DTO(entitySaved);
        return result;
    }

}
