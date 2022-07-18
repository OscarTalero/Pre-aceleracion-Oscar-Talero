package com.alkemy.disney.service;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.GenderDTO;
import com.alkemy.disney.entity.CharacterEntity;

import java.util.List;

public interface CharacterService {

    CharacterDTO addCharacter (CharacterDTO dto);

//    List<CharacterDTO> getAllCharacters();
    void deleteCharacter(Long id);
    CharacterDTO updateCharacter(Long id, CharacterDTO character);

    CharacterDTO getCharacterDetailsById (Long id);

    List<CharacterDTO> getCharactersByFilters (String name, Integer age, Integer weight, List<Long> movies);

}
