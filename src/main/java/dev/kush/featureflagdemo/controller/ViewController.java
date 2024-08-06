package dev.kush.featureflagdemo.controller;

import dev.kush.featureflagdemo.constant.FlagConstant;
import io.getunleash.Unleash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final Unleash unleash;

    public ViewController(Unleash unleash) {
        this.unleash = unleash;
    }

    @GetMapping("/")
    public String getHomeView() {
        if (unleash.isEnabled(FlagConstant.HOME_VIEW_FLAG)) {
            return "home-new";
        } else {
            return "home";
        }
    }
}
