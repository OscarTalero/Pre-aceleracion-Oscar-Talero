package com.alkemy.disney.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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


    @ManyToMany(mappedBy = "characters")
    private List<MovieEntity> movies = new ArrayList<>();



}
