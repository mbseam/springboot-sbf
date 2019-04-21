package com.mb.sbf.test;

import com.mb.sbf.controller.CategoryController;
import com.mb.sbf.io.res.CategoryResponse;
import com.mb.sbf.model.Category;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

public class MockitoControllerTest {

    @Test
    public void testGetUserById() throws URISyntaxException {
        //CategoryController categoryController = new CategoryController();
        //ResponseEntity<CategoryResponse> categoryResponse = categoryController.getCategory(1L);
        //assertEquals(1L, categoryResponse.getBody().getCategoryId().longValue());
        //assertEquals(1l, 1l);

        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080/sbf/category/get?id=1";
        URI uri = new URI(baseUrl);

        ResponseEntity<CategoryResponse> result = restTemplate.getForEntity(uri, CategoryResponse.class);

        //Verify request succeed
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().getCategoryId().equals(1L));
    }
}