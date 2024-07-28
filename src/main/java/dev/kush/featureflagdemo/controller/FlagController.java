package dev.kush.featureflagdemo.controller;

import dev.kush.featureflagdemo.service.FlagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlagController {

    private final FlagService flagService;

    public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return flagService.sayHello();
    }

    @GetMapping("/hi")
    public String sayHi() {
        return flagService.sayHi();
    }
}
