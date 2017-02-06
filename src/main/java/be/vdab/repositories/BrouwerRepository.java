package be.vdab.repositories;

import be.vdab.entities.Brouwer;

import java.util.List;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
public interface BrouwerRepository {
    void create(Brouwer brouwer);
    List<Brouwer> findAll();
    List<Brouwer> findByNaam(String beginNaam);
}
