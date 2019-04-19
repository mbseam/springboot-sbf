package com.mb.sbf.service;

import com.mb.sbf.dto.FilmDto;
import com.mb.sbf.dto.FilmsDto;
import com.mb.sbf.repo.FilmRepository;
import com.mb.sbf.model.Film;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmService {

	@Autowired
	FilmRepository filmRepository;
	
	@Autowired
	Mapper mapper;
	
	public FilmsDto getFilmByReleaseYear(Integer year) {
		List<Film> films = filmRepository.getFilmByReleaseYear(year);
		List<FilmDto> filmDtos = films.stream().map(f->mapper.map(f, FilmDto.class)).collect(Collectors.toList());
		return new FilmsDto(filmDtos);
	}

	public FilmsDto getFilmByCategoryId(Integer categoryId) {
		List<Film> films = filmRepository.getFilmByCategoryId(categoryId);
		List<FilmDto> filmDtos = films.stream().map(f->mapper.map(f, FilmDto.class)).collect(Collectors.toList());
		return new FilmsDto(filmDtos);
	}

	public FilmsDto getFilmByLanguageId(Integer languageId) {
		List<Film> films = filmRepository.getFilmByLanguageId(languageId);
		List<FilmDto> filmDtos = films.stream().map(f->mapper.map(f, FilmDto.class)).collect(Collectors.toList());
		return new FilmsDto(filmDtos);
	}
}
