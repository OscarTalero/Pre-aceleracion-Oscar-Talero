package com.alkemy.disney.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
 //   private String creationDate;
    private Integer rating;
    private List<CharacterDTO> characters;
    private GenderDTO gender;

}
