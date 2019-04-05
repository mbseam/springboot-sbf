package com.mb.sbf.dto;

public class FilmDto {

    public FilmDto(Long filmId, Integer languageId) {
        this.filmId = filmId;
        this.languageId = languageId;
    }

    public FilmDto() {
    }

    Long filmId;
    Integer languageId;
}
