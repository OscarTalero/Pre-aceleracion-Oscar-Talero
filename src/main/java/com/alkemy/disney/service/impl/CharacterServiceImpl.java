package com.alkemy.disney.service.impl;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.CharacterFiltersDTO;
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

/*  public List<CharacterDTO> getAllCharacters(){
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterDTO> result = characterMapper.characterEntityList2DTOList(entities, false);
        return result;
    }*/

    //Delete character
    public void deleteCharacter (Long id){
        characterRepository.deleteById(id);
    }

    //Update character
    public CharacterDTO updateCharacter (Long id, CharacterDTO dto){
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        CharacterEntity entityFind = entity.get();
        CharacterEntity entityUpdated = characterMapper.updateEntity(entityFind, dto);
        CharacterEntity entitySaved = characterRepository.save(entityUpdated);
        CharacterDTO result = characterMapper.characterEntity2DTO(entitySaved, false);
        return result;
    }

    //Get all caharacters or by Id
    public CharacterDTO getCharacterDetailsById (Long id){
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Gender Id not valid");
        }
        return  characterMapper.characterEntity2DTO(entity.get(), true);
    }

    //Filters
    public List<CharacterDTO> getCharactersByFilters(String name, Integer age, Integer weight, List<Long> movies){
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name, age, weight, movies);
        List<CharacterEntity> entitiesList = characterRepository.findAll(characterSpecification.getCharactersByFilters(filtersDTO));
        return characterMapper.characterEntityList2DTOList(entitiesList, true);

    }
}
