package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;

import java.util.List;

public interface CharacterService {

    CharacterDTO addCharacter (CharacterDTO dto);
    void deleteCharacter(Long id);
    CharacterDTO updateCharacter(Long id, CharacterDTO character);
    CharacterDTO getCharacterDetailsById (Long id);
    List<CharacterBasicDTO> getCharactersByFilters (String name, Integer age, Integer weight, List<Long> movies);
    CharacterEntity getCharacterEntityById (Long id);
}
