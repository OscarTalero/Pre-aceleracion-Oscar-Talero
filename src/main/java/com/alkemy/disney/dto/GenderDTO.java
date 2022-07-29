package com.alkemy.disney.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GenderDTO {

    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String image;

}
