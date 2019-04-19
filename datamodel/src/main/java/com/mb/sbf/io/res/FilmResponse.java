package com.mb.sbf.io.res;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FilmResponse {

    private String description;
    private String fulltext;
    private Integer length;
    private String rating;
    private Integer releaseYear;
    private Integer rentalDuration;
    private BigDecimal rentalRate;
    private BigDecimal replacementCost;
    private String specialFeatures;
    private String title;
}
