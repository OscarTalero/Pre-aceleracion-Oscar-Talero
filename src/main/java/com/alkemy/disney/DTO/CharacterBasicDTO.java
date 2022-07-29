package com.alkemy.disney.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CharacterBasicDTO {
    @NotNull
    String name;
    @NotNull
    String image;
}
