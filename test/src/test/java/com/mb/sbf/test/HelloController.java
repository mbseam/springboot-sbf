package com.mb.sbf.test;

import com.mb.sbf.controller.StartController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloController {

    @Test
    public void testHomeController() {
        StartController startController = new StartController();
        String hiMessage = startController.hello();
        assertEquals(hiMessage, "hello");
    }
}
