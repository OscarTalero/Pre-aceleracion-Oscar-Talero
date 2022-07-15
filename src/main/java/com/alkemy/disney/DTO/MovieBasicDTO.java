package com.alkemy.disney.DTO;

import lombok.Data;

@Data
public class MovieBasicDTO {
    private String image;
    private String title;
    private String creationDate;
    private GenderDTO gender;
}
