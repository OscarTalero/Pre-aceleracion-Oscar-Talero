package com.alkemy.disney.DTO;

import lombok.Data;

import java.util.List;

@Data
public class MovieFiltersDTO {
    private String title;
    private List<Long> genre;
    private String order;

    public MovieFiltersDTO(String title, List<Long> genre, String order) {
        this.title = title;
        this.genre = genre;
        this.order = order;
    }

    public boolean isASC() {
        return order.compareToIgnoreCase("ASC") == 0 ;
    }
    public boolean isDESC() {
        return order.compareToIgnoreCase("DESC") == 0 ;
    }
}
