package be.vdab.services;

import be.vdab.entities.Brouwer;
import be.vdab.repositories.BrouwerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
@Service
@ReadOnlyTransactionalService
public class DefaultBrouwerService implements BrouwerService{
    private final BrouwerRepository brouwerRepository;

    public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
        this.brouwerRepository = brouwerRepository;
    }

    @Override
    @ModifyingTransactionalServiceMethod
    public void create(Brouwer brouwer) {
        brouwerRepository.save(brouwer);
    }

    @Override
    public List<Brouwer> findAll() {
        return brouwerRepository.findAll();
    }

    @Override
    public List<Brouwer> findByNaamStartingWith(String beginNaam) {
        return brouwerRepository.findByNaamStartingWith(beginNaam);
    }
}
