package com.alkemy.disney.DTO;

import lombok.Data;

@Data
public class CharacterDTO {
    private Long id;
    private String name;
    private String image;
    private Integer age;
    private Integer weight;
    private String history;
}
