package com.alkemy.disney.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;

public class MovieDTO {
    private Long id;
    private String image;
    private String title;
    //private LocalDate creationDate;
    private Integer calification;
}
