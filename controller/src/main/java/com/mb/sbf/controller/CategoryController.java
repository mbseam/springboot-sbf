package com.mb.sbf.controller;

import com.mb.sbf.dto.CategoriesDto;
import com.mb.sbf.dto.CategoryDto;
import com.mb.sbf.exception.CategoryNotFoundException;
import com.mb.sbf.io.req.CreateCategoryRequest;
import com.mb.sbf.io.res.CategoriesResponse;
import com.mb.sbf.io.res.CategoryResponse;
import com.mb.sbf.service.CategoryService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sbf/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<CategoriesResponse> getCategoryList() {

        CategoriesDto categoriesDto = categoryService.getCategories();
        CategoriesResponse listCategoryResponse = mapper.map(categoriesDto, CategoriesResponse.class);
        return new ResponseEntity<>(listCategoryResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody CreateCategoryRequest categoryRequest) {
        categoryService.createCategory(mapper.map(categoryRequest, CreateCategoryRequest.class));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<CategoryResponse> getCategory(@RequestParam(value = "id") Long id) throws CategoryNotFoundException {
        CategoryDto categoryDto = categoryService.getCategory(id);
        CategoryResponse categoryResponse = mapper.map(categoryDto, CategoryResponse.class);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
}
