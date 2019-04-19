package com.mb.sbf.controller;

import com.mb.sbf.io.res.FilmsResponse;
import com.mb.sbf.service.FilmService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbf/film")
public class FilmController {

	@Autowired
	FilmService filmService;
	
	@Autowired
	Mapper mapper;

	@RequestMapping(value = "/listbyrelease", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilmsByReleaseDate(@RequestParam(value = "year") Integer year) {
		FilmsResponse filmsResponse = mapper.map(filmService.getFilmByReleaseYear(year), FilmsResponse.class);
		return new ResponseEntity<>(filmsResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/listbycategory", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilmByCategory(@RequestParam(value = "categoryId") Integer categoryId) {
		FilmsResponse filmsResponse =  mapper.map(filmService.getFilmByCategoryId(categoryId), FilmsResponse.class);
		return new ResponseEntity<>(filmsResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/listbylanguage", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilmByLanguage(@RequestParam(value = "languageId") Integer languageId) {
		FilmsResponse filmsResponse =  mapper.map(filmService.getFilmByLanguageId(languageId), FilmsResponse.class);
		return new ResponseEntity<>(filmsResponse, HttpStatus.OK);
	}
}
