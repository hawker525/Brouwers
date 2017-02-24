package be.vdab.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

/**
 * Created by Maarten Westelinck on 2/02/2017 for brouwers.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    private static final String VIEW = "index";

    @GetMapping
    ModelAndView index() {
        int hour = LocalTime.now().getHour();
        String msg;
        if (hour <= 5) {
            msg = "nacht";
        } else if (hour <= 11) {
            msg = "morgen";
        } else if (hour <= 17) {
            msg = "middag";
        } else {
            msg = "avond";
        }
        return new ModelAndView(VIEW).addObject("msg", msg);
    }
}
