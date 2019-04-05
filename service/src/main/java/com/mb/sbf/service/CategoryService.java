package com.mb.sbf.service;

import com.mb.sbf.exception.CategoryNotFoundException;
import com.mb.sbf.repo.CategoryRepository;
import com.mb.sbf.io.req.CreateCategoryRequest;
import com.mb.sbf.io.res.ListCategoryResponse;
import com.mb.sbf.model.Category;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

	@Autowired
    CategoryRepository categoryRepository;
	@Autowired
	Mapper mapper;
	
	public void createCategory(CreateCategoryRequest categoryRequest) {
		Category category = new Category();
		category.setName(categoryRequest.getName());
		category.setLastUpdate(new Date());
		categoryRepository.save(category);
	}

	public ListCategoryResponse getCategories() {

		ListCategoryResponse listCategoryResponse = new ListCategoryResponse();
		List<Category> categories = categoryRepository.findAll();
		listCategoryResponse.setCategories(categories);
		return listCategoryResponse;
	}
	
	public Category getCategory(Long id) throws CategoryNotFoundException {
		Optional<Category> category = categoryRepository.findById(id);

		if(!category.isPresent())
			throw new CategoryNotFoundException();

		return mapper.map(category.get(), Category.class);
	}
}
