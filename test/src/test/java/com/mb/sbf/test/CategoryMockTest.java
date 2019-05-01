package com.mb.sbf.test;

import com.mb.sbf.dto.CategoriesDto;
import com.mb.sbf.model.Category;
import com.mb.sbf.repo.CategoryRepository;
import com.mb.sbf.service.CategoryService;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CategoryMockTest {

    @InjectMocks
    CategoryService categoryService;

    @Mock
    CategoryRepository categoryRepository;

    @Mock
    Mapper mapper;

    @Test
    public void categoriesTest() {

        List<Category> categories = new ArrayList<>();

        Category category = new Category();
        category.setCategoryId(1L);
        category.setName("Anime");
        categories.add(category);

        Category category2 = new Category();
        category2.setCategoryId(2L);
        category2.setName("Anime2");
        categories.add(category2);

        when(categoryRepository.findAll()).thenReturn(categories);
        CategoriesDto categoryDtoObj = categoryService.getCategories();
        assertEquals(2L, categoryDtoObj.getCategories().size());
    }
}
