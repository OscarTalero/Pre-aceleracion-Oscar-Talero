

package com.alkemy.disney.service.impl;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;

    @Autowired
    CharacterRepository characterRepository;

    public CharacterDTO addCharacter(CharacterDTO dto) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity entitySaved = characterRepository.save(entity);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved, false);
        return result;
    }

  public List<CharacterDTO> getAllCharacters(){
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities, false);
        return result;
    }

    public void deleteCharacter (Long id){
        characterRepository.deleteById(id);
    }

    public CharacterDTO updateCharacter (Long id, CharacterDTO dto){
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        CharacterEntity entityFind = entity.get();
        CharacterEntity entityUpdated = characterMapper.updateEntity(entityFind, dto);
        CharacterEntity entitySaved = characterRepository.save(entityUpdated);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved, false);
        return result;
    }

}
