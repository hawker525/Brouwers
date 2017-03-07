package be.vdab.entities;

import be.vdab.valueobjects.Adres;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
@Entity
@Table(name = "brouwers")
public final class Brouwer {
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
}
