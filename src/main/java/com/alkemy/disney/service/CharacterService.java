package com.alkemy.disney.service;

import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.DTO.GenderDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save (CharacterDTO dto);
    List<CharacterDTO> getAllCharacters();
    void delete(Long id);
    CharacterDTO update(Long id, CharacterDTO character);

}
