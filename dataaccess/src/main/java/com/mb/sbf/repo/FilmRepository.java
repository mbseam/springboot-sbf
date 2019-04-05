package com.mb.sbf.repo;

import com.mb.sbf.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository extends CrudRepository<Film ,Long>{

	List<Film> getFilmByReleaseYear(Integer year);
	
	@Query(value = "select f.* from film f join film_category fc on fc.film_id = f.film_id join category c on c.category_id = fc.category_id  where c.category_id = ?1", nativeQuery = true)
	List<Film> getFilmByCategoryId(Integer categoryId);
}
