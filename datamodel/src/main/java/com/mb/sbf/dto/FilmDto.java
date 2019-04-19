package com.mb.sbf.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class FilmDto {

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
