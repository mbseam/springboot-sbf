package com.mb.sbf.controller;

import com.mb.sbf.io.res.ListFilmDtoResponse;
import com.mb.sbf.io.res.ListFilmResponse;
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
		ListFilmResponse listFilmResponse = mapper.map(filmService.getFilmByReleaseYear(year), ListFilmResponse.class);
		return new ResponseEntity<>(listFilmResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/listbycategory", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilmByCategory(@RequestParam(value = "categoryId") Integer categoryId) {
		ListFilmResponse listFilmResponse =  mapper.map(filmService.getFilmByCategoryId(categoryId), ListFilmResponse.class);
		return new ResponseEntity<>(listFilmResponse, HttpStatus.OK);
	}

	@RequestMapping(value = "/listbycategorymulti", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilmByCategoryMulti(@RequestParam(value = "categoryId") Integer categoryId) {
		ListFilmDtoResponse listFilmDtoResponse = mapper.map(filmService.getFilmByCategoryId(categoryId), ListFilmDtoResponse.class);
		return new ResponseEntity<>(listFilmDtoResponse, HttpStatus.OK);
	}
}
