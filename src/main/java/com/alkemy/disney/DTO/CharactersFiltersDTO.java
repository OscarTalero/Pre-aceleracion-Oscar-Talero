package com.alkemy.disney.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class CharactersFiltersDTO {
    private String name;
    private Integer age;
    private Integer weight;
    private List<Long> movies;

    public CharactersFiltersDTO(String name, Integer age, Integer weight, List<Long> movies){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }
}
