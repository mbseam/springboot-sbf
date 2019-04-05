package com.mb.sbf.controller;

import com.mb.sbf.exception.CategoryNotFoundException;
import com.mb.sbf.io.res.CategoryResponse;
import com.mb.sbf.io.req.CreateCategoryRequest;
import com.mb.sbf.io.res.ListCategoryResponse;
import com.mb.sbf.model.Category;
import com.mb.sbf.service.CategoryService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sbf/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    Mapper mapper;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<Object> getCategoryList() {
        ListCategoryResponse listCategoryResponse = mapper.map(categoryService.getCategories(), ListCategoryResponse.class);
        return new ResponseEntity<>(listCategoryResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody CreateCategoryRequest categoryRequest) {
        categoryService.createCategory(mapper.map(categoryRequest, CreateCategoryRequest.class));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> getProductType(@RequestParam(value = "id") Long id) throws CategoryNotFoundException {
        Category category = categoryService.getCategory(id);

        CategoryResponse categoryResponse = mapper.map(category, CategoryResponse.class);
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }
}
