package com.alkemy.disney.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table( name = "genders")
public class GenderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String image;

}
