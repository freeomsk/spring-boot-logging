package ru.freeomsk.springbootlogging.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoController {
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/hello")
    public Map<String, String> hello(@RequestParam(defaultValue = "Мир") String name) {
        logger.trace("Имя: {}", name);
//        if(logger.isTraceEnabled()) {
//            logger.trace("some", aMethodToPrintVerboseInfo());
//        }
        return Map.of("приветствие", "Привет, " + name);
    }
}
