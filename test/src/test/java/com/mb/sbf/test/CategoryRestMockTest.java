package com.mb.sbf.test;

import com.mb.sbf.io.res.CategoryResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class CategoryRestMockTest {

    @Test
    public void restCategoryTest() throws URISyntaxException {

        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:8080/sbf/category/get?id=1";
        URI uri = new URI(baseUrl);

        ResponseEntity<CategoryResponse> result = restTemplate.getForEntity(uri, CategoryResponse.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(true, result.getBody().getCategoryId().equals(1L));
    }
}