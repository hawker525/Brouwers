package be.vdab.entities;

import be.vdab.valueobjects.Adres;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
public final class Brouwer {
    private final long brouwerNr;
    private final String naam;
    private final Integer omzet;
    private final Adres adres;

    public Brouwer(long brouwerNr, String naam, Integer omzet, Adres adres) {
        this.brouwerNr = brouwerNr;
        this.naam = naam;
        this.omzet = omzet;
        this.adres = adres;
    }

    public long getBrouwerNr() {
        return brouwerNr;
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
