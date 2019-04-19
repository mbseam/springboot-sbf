package com.mb.sbf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class FilmsDto {

    List<FilmDto> films = new ArrayList<>();
}
