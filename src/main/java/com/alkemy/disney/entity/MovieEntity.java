package com.alkemy.disney.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table( name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;
    private String title;

    @Column( name = "creation_date")
    //@DateTimeFormat( pattern = "yyyy/mm/dd")
    //private LocalDate creationDate;
    private String date; //TODO: change date type

    private Integer calification;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private List<CharacterEntity> characters = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id", insertable = false, updatable = false)
    private GenderEntity gender;

    @Column(name = "gender_id", nullable = false)
    private Long gender_id;



}