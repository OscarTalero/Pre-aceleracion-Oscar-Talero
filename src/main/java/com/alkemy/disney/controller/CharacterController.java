package com.alkemy.disney.controller;

import com.alkemy.disney.DTO.CharacterBasicDTO;
import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

/*
    @GetMapping
    public ResponseEntity<List<CharacterDTO>> getAllCharacters() {
        List<CharacterDTO> characters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(characters);
    }
*/

    //Add Character
    @PostMapping
    public ResponseEntity<CharacterDTO> addCharacter(@RequestBody CharacterDTO characterDTO) {
        CharacterDTO characterSaved = characterService.addCharacter(characterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }

    //Delete character
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Update character
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody CharacterDTO character) {
        CharacterDTO result = characterService.updateCharacter(id, character);
        return ResponseEntity.ok().body(result);
    }

    //Get all characters or by Id
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharactersDetailsById(@PathVariable Long id) {
        CharacterDTO characterDto = characterService.getCharacterDetailsById(id);
        return ResponseEntity.ok(characterDto);
    }

    //Filters
    @GetMapping
        public ResponseEntity<List<CharacterBasicDTO>> getDetailsByFilter(
        @RequestParam(required = false) String name,
        @RequestParam(required = false) Integer age,
        @RequestParam(required = false) Integer weight,
        @RequestParam(required = false) List<Long> movies)
        {
            List<CharacterBasicDTO> characters = this.characterService.getCharactersByFilters(name, age, weight, movies);
            return ResponseEntity.ok(characters);
        }


        /*{
        List<CharacterDTO> characters = this.characterService.getCharactersByFilters(name, age, weight, movies);
        return ResponseEntity.ok(characters);
        }*/
}
