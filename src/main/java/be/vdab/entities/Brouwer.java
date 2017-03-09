package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
@Entity
@Table(name = "brouwers")
@XmlRootElement
public final class Brouwer implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Length(min = 1, max = 50)
    private String naam;

    @Min(0)
    @NumberFormat(style = NumberFormat.Style.CURRENCY)
    private Integer omzet;

    @Valid
    @Embedded
    private Adres adres;

    @Version
    private long versie;

    public Brouwer() {

    }

    public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
        this.id = brouwerNr;
        this.naam = naam;
        this.omzet = omzet;
        this.adres = adres;
    }


    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Integer getOmzet() {
        return omzet;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setOmzet(Integer omzet) {
        this.omzet = omzet;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public void setVersie(long versie) {
        this.versie = versie;
    }
}
