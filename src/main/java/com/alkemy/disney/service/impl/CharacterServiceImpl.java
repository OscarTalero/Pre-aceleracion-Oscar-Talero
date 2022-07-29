package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.repository.Specifications.CharacterSpecification;
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
    @Autowired
    private CharacterSpecification characterSpecification;

    //Add character
    public CharacterDTO addCharacter(CharacterDTO dto) {
        CharacterEntity entity = characterMapper.characterDTO2Entity(dto);
        CharacterEntity entitySaved = characterRepository.save(entity);
        return characterMapper.characterEntity2DTO(entitySaved, false);
    }

    //Delete character
    public void deleteCharacter (Long id){
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Character ID not valid");
        }characterRepository.deleteById(id);
    }

    //Update character
    public CharacterDTO updateCharacter (Long id, CharacterDTO dto){
        Optional<CharacterEntity> entity = this.characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Character ID not valid");
        }
        characterMapper.updateEntity(entity.get(), dto);
        CharacterEntity entitySaved = characterRepository.save(entity.get());
        return characterMapper.characterEntity2DTO(entitySaved, true);
    }

    //Get all caharacters details or by Id
    public CharacterDTO getCharacterDetailsById (Long id){
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Character Id not valid");
        }
        return  characterMapper.characterEntity2DTO(entity.get(), true);
    }

    //Filters
    public List<CharacterBasicDTO> getCharactersByFilters(String name, Integer age, Integer weight, List<Long> movies){
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, weight, movies);
        List<CharacterEntity> entitiesList = characterRepository.findAll(characterSpecification.getCharactersByFilters(filtersDTO));
        return characterMapper.characterEntityList2DTOBasicList(entitiesList);
    }

    //Get by Id
    public CharacterEntity getCharacterEntityById (Long characterId) {
        Optional<CharacterEntity> character = characterRepository.findById(characterId);
        if (!character.isPresent()) {
            throw new ParamNotFound("Character Id not valid");
        }
        return character.get();
    }
}
