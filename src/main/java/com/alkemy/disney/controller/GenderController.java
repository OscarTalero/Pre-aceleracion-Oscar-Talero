package com.alkemy.disney.controller;

import com.alkemy.disney.dto.GenderDTO;
import com.alkemy.disney.service.GenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("genders")
@Api( tags = "Genders")
public class GenderController {

    @Autowired
    private GenderService genderService;

    @ApiOperation(value = "This method is used to get all Genders.")
    @GetMapping
    public ResponseEntity<List<GenderDTO>> getAllGenders() {
        List<GenderDTO> gendersDTO = genderService.getAllGenders();
        return ResponseEntity.ok().body(gendersDTO);
    }

    @ApiOperation(value = "This method is used to add a Gender.")
    @PostMapping
    public ResponseEntity<GenderDTO> addGender(@RequestBody GenderDTO gender) {
        GenderDTO genderSaved = genderService.addGender(gender);
        return ResponseEntity.status(HttpStatus.CREATED).body(genderSaved);
    }

   @ApiOperation(value = "This method is used to remove a Gender.")
   @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGender(@PathVariable Long id) {
        genderService.deleteGender(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @ApiOperation(value = "This method is used to update a Gender.")
    @PutMapping("/{id}")
    public ResponseEntity<GenderDTO> updateGender(@PathVariable Long id, @RequestBody GenderDTO gender) {
        GenderDTO result = genderService.updateGender(id, gender);
        return ResponseEntity.ok().body(result);
    }
}
