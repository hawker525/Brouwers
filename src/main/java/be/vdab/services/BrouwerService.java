package be.vdab.services;

import be.vdab.entities.Brouwer;

import java.util.List;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
public interface BrouwerService {
    void create(Brouwer brouwer);

    List<Brouwer> findAll();

    List<Brouwer> findByNaamStartingWith(String beginNaam);
}
