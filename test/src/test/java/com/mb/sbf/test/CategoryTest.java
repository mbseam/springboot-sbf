package com.mb.sbf.test;

import com.mb.sbf.controller.CategoryController;
import com.mb.sbf.controller.StartController;
import com.mb.sbf.io.res.CategoriesResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CategoryTest {

    @Test
    public void testHomeController() {
        StartController startController = new StartController();
        String hiMessage = startController.hello();
        assertEquals(hiMessage, "hello");
    }
}
