package be.vdab.restservices;

import be.vdab.entities.Brouwer;
import be.vdab.exceptions.BrouwerNietGevondenException;
import be.vdab.services.BrouwerService;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Maarten Westelinck on 9/03/2017 for Brouwers.
 */
@RestController
@ExposesResourceFor(Brouwer.class)
@RequestMapping("/brouwers")
public class BrouwerRestController {
    private final BrouwerService brouwerService;
    private final EntityLinks entityLinks;

    public BrouwerRestController(BrouwerService brouwerService, EntityLinks entityLinks) {
        this.brouwerService = brouwerService;
        this.entityLinks = entityLinks;
    }

    @GetMapping("{brouwer}")
    BrouwerResource read(@PathVariable Brouwer brouwer) {
        if (brouwer == null) {
            throw new BrouwerNietGevondenException();
        }
        return new BrouwerResource(brouwer, entityLinks);
    }

    @GetMapping(params = "beginnaam")
    BrouwersResource findByBeginnaam(String beginnaam) {
        return new BrouwersResource(brouwerService.findByNaamStartingWith(beginnaam), entityLinks);
    }

//    @GetMapping("{brouwer}")
//    Brouwer read(@PathVariable Brouwer brouwer) {
//        return brouwer;
//    }


    @ExceptionHandler(BrouwerNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void brouwerNietGevonden(){}
}
