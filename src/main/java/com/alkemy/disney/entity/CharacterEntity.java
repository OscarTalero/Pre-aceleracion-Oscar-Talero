package com.alkemy.disney.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "characters")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String image;
    private Integer age;
    private Integer weight;
    private String history;

 /*   @ManyToMany(mappedBy = "movies")
    private Set<MovieEntity> movies = new HashSet<>();*/


}
