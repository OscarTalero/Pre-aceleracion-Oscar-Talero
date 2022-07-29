package com.alkemy.disney.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CharacterFiltersDTO {
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    private Integer weight;
    private List<Long> movies;

    public CharacterFiltersDTO(String name, Integer age, Integer weight, List<Long> movies){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }
}
