package com.alkemy.disney.DTO;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    //private LocalDate creationDate;
    private Integer calification;
   // private List<CharacterEntity> characters;
    private GenderDTO gender;

    
    //private GenderIdDTO genderIdDTO;
   // private GenderNameDTO genderNameDTO;
}
