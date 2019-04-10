package com.example.log4j2demo.controller;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Log4j2Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Log4j2Controller.class);

    @GetMapping("/")
    public void log(@RequestParam(name = "bu") String bu) {
        //TODO: Esse ponto pode ser incluido no filter para que seja trafegado na thread e utilizado pelos logs.
        ThreadContext.put("bu", bu);

        LOGGER.debug("Debugging log");
        LOGGER.info("Info log");
        LOGGER.warn("Hey, This is a warning!");
        LOGGER.error("Oops! We have an Error. OK");
        LOGGER.trace("I'm going this way.");
    }
}
