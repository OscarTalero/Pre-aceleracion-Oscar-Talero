package com.alkemy.disney.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;



@Data
@Entity
@Table( name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String image;
    private String title;

 /*   @Column( name = "creation_date")
    @DateTimeFormat( pattern = "yyyy/mm/dd")
    private LocalDate creationDate;
*/

    private Integer calification; //TODO change to enum

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id")
    private GenderEntity gender;

  /*  @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private Set<CharacterEntity> characters = new HashSet<>();*/




}
