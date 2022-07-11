package com.alkemy.disney.DTO;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class CharacterDTO {
    private Long id;
    private String name;
    private String image;
    private Integer age;
    private Integer weight;
    private String history;
    private Set<MovieEntity> movies = new HashSet<>();
}
