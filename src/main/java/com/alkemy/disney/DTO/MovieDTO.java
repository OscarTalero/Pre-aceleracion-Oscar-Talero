package com.alkemy.disney.DTO;


import com.alkemy.disney.entity.CharacterEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class MovieDTO {
    private Long id;
    private String image;
    private String title;
 //   private LocalDate creationDate;
    private Integer rating;
    private Set<CharacterEntity> characters = new HashSet<>();
    private GenderDTO gender;

}
