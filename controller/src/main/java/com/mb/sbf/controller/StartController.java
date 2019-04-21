package com.mb.sbf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
public class StartController {

    @Value("${welcome.message}")
    String welcomeText;

	@RequestMapping("/")
    public RedirectView swagger(){
	    return new RedirectView("http://localhost:8080/swagger-ui.html");
    }

    @RequestMapping(value = "/welcome")
    public String welcomeText() {
        return welcomeText;
    }

    @RequestMapping(value = "/hi")
    public String hello() {
        return "hello";
    }
}
