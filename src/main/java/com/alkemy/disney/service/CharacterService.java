package com.alkemy.disney.service;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.GenderDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO addCharacter (CharacterDTO dto);

    List<CharacterDTO> getAllCharacters();
    void deleteCharacter(Long id);
    CharacterDTO updateCharacter(Long id, CharacterDTO character);


}
