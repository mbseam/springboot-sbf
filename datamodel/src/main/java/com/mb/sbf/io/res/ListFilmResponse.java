package com.mb.sbf.io.res;

import com.mb.sbf.model.Film;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListFilmResponse extends BaseResponse {
	private List<Film> films = new ArrayList<Film>();
}
