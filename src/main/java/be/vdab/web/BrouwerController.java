package be.vdab.web;

import be.vdab.entities.Brouwer;
import be.vdab.services.BrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
    private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/brouwers";
    private static final String REDIRECT_URL_BROUWERS_NIET_GEVONDEN = "brouwers/beginnaam";
    private static final String NAAM_VIEW = "brouwers/naam";
    private static char[] alfabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private final BrouwerService brouwerService;

    public BrouwerController(BrouwerService brouwerService) {
        this.brouwerService = brouwerService;
    }

    @GetMapping
    ModelAndView findAll() {
        return new ModelAndView(BROUWERS_VIEW, "brouwers", brouwerService.findAll());
    }

    @GetMapping("naam")
    ModelAndView getNaamView() {
        BrouwerZoeken brouwerZoeken = new BrouwerZoeken();
        return new ModelAndView(NAAM_VIEW).addObject(brouwerZoeken);
    }

    @InitBinder("brouwer")
    void initBinderBrouwerToevoegen(WebDataBinder webDataBinder) {
        webDataBinder.initDirectFieldAccess();
    }

    @GetMapping(path = "naam", params = "naam")
    ModelAndView findBrouwersByNaam(@Valid BrouwerZoeken cmdObj, BindingResult bindingResult) {
        ModelAndView mAndV = new ModelAndView(NAAM_VIEW);
        if (!bindingResult.hasErrors()) {
            List<Brouwer> brouwers = brouwerService.findByNaam(cmdObj.getNaam());
            if (brouwers.isEmpty()) {
                bindingResult.reject("geenBrouwers");
            } else {
                mAndV.addObject("brouwers", brouwers);
            }
        }
        return mAndV;
    }

    @GetMapping("toevoegen")
    ModelAndView createForm() {
        return new ModelAndView(TOEVOEGEN_VIEW, "brouwer", new Brouwer());
    }

    @PostMapping("toevoegen")
    String create(@Valid Brouwer brouwer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return TOEVOEGEN_VIEW;
        } else {
            brouwerService.create(brouwer);
            return REDIRECT_URL_NA_TOEVOEGEN;
        }
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
