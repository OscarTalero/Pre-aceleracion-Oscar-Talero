package com.alkemy.disney.DTO;

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
