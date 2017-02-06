package be.vdab.services;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import be.vdab.repositories.InMemoryBrouwerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
@Service
public class DefaultBrouwerService implements BrouwerService{
    private final BrouwerRepository brouwerRepository;

    public DefaultBrouwerService() {
        this.brouwerRepository = new InMemoryBrouwerRepository();
    }

    @Override
    public void create(Brouwer brouwer) {
        brouwerRepository.create(brouwer);
    }

    @Override
    public List<Brouwer> findAll() {
        return brouwerRepository.findAll();
    }

    @Override
    public List<Brouwer> findByNaam(String beginNaam) {
        return brouwerRepository.findByNaam(beginNaam);
    }
}
