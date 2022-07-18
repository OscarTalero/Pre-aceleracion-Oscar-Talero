package com.alkemy.disney.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CharacterFiltersDTO {
    private String name;
    private Integer age;
    private Integer weight;
    private List<Long> movies;

    public CharacterFiltersDTO(String name, Integer age, Integer weight, List<Long> movies){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }
}
