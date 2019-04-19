package com.mb.sbf.io.res;

import com.mb.sbf.dto.FilmDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmsResponse extends  BaseResponse {

    List<FilmDto> films = new ArrayList<>();
}
