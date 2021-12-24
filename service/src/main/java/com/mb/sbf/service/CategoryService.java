package com.mb.sbf.service;

import com.mb.sbf.dto.CategoriesDto;
import com.mb.sbf.dto.CategoryDto;
import com.mb.sbf.exception.CategoryNotFoundException;
import com.mb.sbf.io.req.CreateCategoryRequest;
import com.mb.sbf.model.Category;
import com.mb.sbf.repo.CategoryRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

	@Autowired
    CategoryRepository categoryRepository;
	@Autowired
	Mapper mapper;

	@Transactional
	public void createCategory(CreateCategoryRequest categoryRequest) {
		Category category = new Category();

		category.setName(categoryRequest.getName());
		category.setLastUpdate(new Date());
		categoryRepository.save(category);
	}

	public CategoriesDto getCategories() {
		List<Category> categories = categoryRepository.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map(f->mapper.map(f, CategoryDto.class)).collect(Collectors.toList());
		return new CategoriesDto(categoryDtos);
	}
	
	public CategoryDto getCategory(Long id) throws CategoryNotFoundException {
		Optional<Category> category = categoryRepository.findById(id);

		if(!category.isPresent())
			throw new CategoryNotFoundException();

		return mapper.map(category.get(), CategoryDto.class);
	}
}
