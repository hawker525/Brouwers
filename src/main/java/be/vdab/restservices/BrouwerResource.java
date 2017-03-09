package be.vdab.restservices;

import be.vdab.entities.Brouwer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Maarten Westelinck on 9/03/2017 for Brouwers.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
class BrouwerResource extends ResourceSupport{

    private Brouwer brouwer;

    BrouwerResource(){}

    BrouwerResource(Brouwer brouwer, EntityLinks entityLinks) {
        this.brouwer = brouwer;
        this.add(entityLinks.linkToSingleResource(Brouwer.class, brouwer.getId()));
    }
}
