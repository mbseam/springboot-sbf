package com.mb.sbf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.logging.Level;

@RestController
@RequestMapping("/")
public class StartController {

    private Logger log = LoggerFactory.getLogger(StartController.class);

    @Value("${welcome.message}")
    String welcomeText = "";

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public RedirectView swagger(){
	    return new RedirectView("http://localhost:8080/swagger-ui.html");
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomeText() {
        return welcomeText;
    }

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String hello() {

        log.info("Inside microservice#3");
	    return "hello";
    }
}
