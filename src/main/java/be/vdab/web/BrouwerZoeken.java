package be.vdab.web;

import be.vdab.constraints.BeginNaam;

import javax.validation.constraints.NotNull;

/**
 * Created by Maarten Westelinck on 27/02/2017 for Brouwers.
 */
class BrouwerZoeken {
    @BeginNaam
    @NotNull
    private String naam;

    protected BrouwerZoeken() {}

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}
