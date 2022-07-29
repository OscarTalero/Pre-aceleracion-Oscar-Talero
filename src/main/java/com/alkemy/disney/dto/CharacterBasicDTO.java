package com.alkemy.disney.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CharacterBasicDTO {
    @NotNull
    String name;
    @NotNull
    String image;
}
