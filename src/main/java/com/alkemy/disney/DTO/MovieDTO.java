package com.alkemy.disney.DTO;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenderEntity;
import lombok.Data;

import java.util.List;

@Data
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    //private LocalDate creationDate;
    private Integer calification;
    private List<CharacterEntity> characters;
    private GenderEntity gender;
}
