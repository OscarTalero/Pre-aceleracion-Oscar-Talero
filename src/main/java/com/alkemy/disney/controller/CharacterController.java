package com.alkemy.disney.controller;

import com.alkemy.disney.DTO.CharacterBasicDTO;
import com.alkemy.disney.DTO.CharacterDTO;
import com.alkemy.disney.service.CharacterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("characters")
@Api( tags = "Characters")
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

    @ApiOperation(value = "This method is used to add a Character.")
    @PostMapping
    public ResponseEntity<CharacterDTO> addCharacter(@RequestBody CharacterDTO characterDTO) {
        CharacterDTO characterSaved = characterService.addCharacter(characterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(characterSaved);
    }

    @ApiOperation(value = "This method is used to remove a specific Character.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "This method is used to update a Character.")
    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@PathVariable Long id, @RequestBody CharacterDTO character) {
        CharacterDTO result = characterService.updateCharacter(id, character);
        return ResponseEntity.ok().body(result);
    }

    @ApiOperation(value = "This method is used to get a Character by ID.")
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharactersDetailsById(@PathVariable Long id) {
        CharacterDTO characterDto = characterService.getCharacterDetailsById(id);
        return ResponseEntity.ok(characterDto);
    }

    @ApiOperation(value = "This method is used to filter Characters.")
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

}
