package com.mb.sbf.service;

import com.mb.sbf.repo.FilmRepository;
import com.mb.sbf.io.res.ListFilmResponse;
import com.mb.sbf.model.Film;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

	@Autowired
	FilmRepository filmRepository;
	
	@Autowired
	Mapper mapper;
	
	public ListFilmResponse getFilmByReleaseYear(Integer year) {

		ListFilmResponse listFilmResponse = new ListFilmResponse();
		List<Film> films = filmRepository.getFilmByReleaseYear(year);

		listFilmResponse.setFilms(films);
		
		return listFilmResponse;
	}
	
	public ListFilmResponse getFilmByCategoryId(Integer categoryId) {

		ListFilmResponse listFilmResponse = new ListFilmResponse();
		List<Film> films = filmRepository.getFilmByCategoryId(categoryId);
		listFilmResponse.setFilms(films);
		
		return listFilmResponse;
	}
}
