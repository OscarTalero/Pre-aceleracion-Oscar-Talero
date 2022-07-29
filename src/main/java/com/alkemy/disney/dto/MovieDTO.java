package com.alkemy.disney.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MovieDTO {
    private Long id;
    @NotNull
    private String image;
    @NotNull
    private String title;
    private String creationDate;
    @NotNull
    private Integer rating;
    private List<CharacterDTO> characters;
    private GenderDTO gender;

}
