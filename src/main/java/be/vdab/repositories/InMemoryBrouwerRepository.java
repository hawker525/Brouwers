package be.vdab.repositories;


import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
@Repository
public class InMemoryBrouwerRepository implements BrouwerRepository{
    private final Map<Long, Brouwer> brouwers = new ConcurrentHashMap();

    public InMemoryBrouwerRepository() {
        brouwers.put(1L, new Brouwer(1, "Bart", 5, new Adres("buntstraat", "29", 9940, "Evergem")));
        brouwers.put(2L, new Brouwer(2, "Maarten", null, new Adres("testlaan", "20", 9940, "Wondelgem")));
        brouwers.put(3L, new Brouwer(2, "Bonobo", null, new Adres("testlaan", "20", 9940, "Wondelgem")));
    }

    @Override
    public void create(Brouwer brouwer) {
        brouwers.put(brouwers.size()+1L, brouwer);
    }

    @Override
    public List<Brouwer> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(brouwers.values()));
    }

    @Override
    public List<Brouwer> findByNaam(String beginNaam) {
        return brouwers.values().stream().filter(b -> b.getNaam().startsWith(beginNaam)).collect(Collectors.toList());
    }
}
