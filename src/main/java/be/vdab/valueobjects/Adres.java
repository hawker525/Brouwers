package be.vdab.valueobjects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.io.Serializable;

/**
 * Created by Maarten Westelinck on 6/02/2017 for groenetenen.
 */
@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public final class Adres implements Serializable{
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Length(min = 1, max = 50)
    private String straat;

    @NotBlank
    @Length(min = 1, max = 7)
    private String huisNr;

    @NotNull
    @Range(min = 1000, max = 9999)
    private Integer postcode;

    @NotBlank
    private String gemeente;

    public Adres(){}

    public Adres(String straat, String huisNr,
                 Integer postcode, String gemeente) {
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public Integer getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

}
