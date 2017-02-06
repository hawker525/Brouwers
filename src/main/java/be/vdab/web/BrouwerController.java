package be.vdab.web;

import be.vdab.services.BrouwerService;
import be.vdab.services.DefaultBrouwerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Maarten Westelinck on 2/02/2017 for brouwers.
 */
@Controller
@RequestMapping("/brouwers")
public class BrouwerController {
    private static final String BROUWERS_VIEW = "brouwers/brouwers";
    private static final String BEGINNAAM_VIEW = "brouwers/beginnaam";
    private static final String TOEVOEGEN_VIEW = "brouwers/toevoegen";
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
    String getBeginnaamView() {
        return BEGINNAAM_VIEW;
    }
}
