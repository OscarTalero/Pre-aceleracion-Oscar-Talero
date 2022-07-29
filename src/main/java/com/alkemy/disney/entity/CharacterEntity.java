package com.alkemy.disney.entity;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "characters")
@SQLDelete(sql = "UPDATE characters SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String image;
    private Integer age;
    private Integer weight;
    private String history;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "characters")
    private List<MovieEntity> movies = new ArrayList<>();

    @Override
    public boolean equals(Object obj){
        if(obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CharacterEntity other = (CharacterEntity) obj;
        return other.id == this.id;
    }
}
