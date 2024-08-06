package dev.kush.featureflagdemo.controller;

import dev.kush.featureflagdemo.constant.FlagConstant;
import io.getunleash.Unleash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {

    private final Unleash unleash;

    public ViewController(Unleash unleash) {
        this.unleash = unleash;
    }

    @GetMapping("/")
    public ModelAndView getHomeView() {
        if (unleash.isEnabled(FlagConstant.HOME_VIEW_FLAG)) {
            return new ModelAndView("home-new");
        } else {
            return new ModelAndView("home");
        }
    }
}
