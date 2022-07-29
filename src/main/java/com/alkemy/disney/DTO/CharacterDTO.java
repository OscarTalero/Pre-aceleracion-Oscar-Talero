package com.alkemy.disney.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CharacterDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String image;
    @NotNull
    private Integer age;
    @NotNull
    private Integer weight;
    @NotNull
    private String history;
    private List<MovieDTO> movies;
}
