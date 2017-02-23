package be.vdab.web;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import be.vdab.services.DefaultBrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Maarten Westelinck on 2/02/2017 for brouwers.
 */
@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
    private static final String BROUWERS_VIEW = "brouwers/brouwers";
    private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
    private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
    private static final String REDIRECT_URL_BROUWERS_NIET_GEVONDEN = "brouwers/beginnaam";
    private static char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private final BrouwerService brouwerService;

    public BrouwerController() {
        this.brouwerService = new DefaultBrouwerService();
    }

    @GetMapping
    ModelAndView findAll() {
        return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
    }

    @GetMapping("toevoegen")
    String createForm() {
        return TOEVOEGEN_VIEW;
    }

    @GetMapping("beginnaam")
    ModelAndView getBeginnaamView() {
        return new ModelAndView(BEGINNAAM_VIEW, "alfabet", alfabet);
    }

    @GetMapping("beginnaam/{letter}")
    ModelAndView showBrouwers(@PathVariable String letter) {
        List<Brouwer> brouwers = brouwerService.findByNaam(letter);
        ModelAndView view = new ModelAndView(BEGINNAAM_VIEW).addObject("alfabet", alfabet).addObject("letter", letter);
        if(!brouwers.isEmpty()){
            return view.addObject("brouwers", brouwers);
        } else {
            return view;
        }
    }
}
