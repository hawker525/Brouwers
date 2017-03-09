package be.vdab.restservices;

import be.vdab.entities.Brouwer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ResourceSupport;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maarten Westelinck on 9/03/2017 for Brouwers.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class BrouwersResource extends ResourceSupport{

    @XmlElement(name = "brouwer")
    @JsonProperty("filialen")
    private List<BrouwerIdNaam> brouwersIdNaam = new ArrayList<>();

    BrouwersResource(){}

    public BrouwersResource(Iterable<Brouwer> brouwers, EntityLinks entityLinks) {
        for (Brouwer b : brouwers) {
            brouwersIdNaam.add(new BrouwerIdNaam(b));
            this.add(entityLinks.linkToSingleResource(Brouwer.class, b.getId()).withRel("Brouwer:" + b.getId()));
        }
        this.add(entityLinks.linkToCollectionResource(Brouwer.class));
    }
}
