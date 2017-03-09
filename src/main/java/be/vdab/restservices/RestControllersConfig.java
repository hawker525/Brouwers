package be.vdab.restservices;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.config.EnableEntityLinks;

/**
 * Created by Maarten Westelinck on 9/03/2017 for Brouwers.
 */
@Configuration
@ComponentScan
@EnableEntityLinks
public class RestControllersConfig {
}
