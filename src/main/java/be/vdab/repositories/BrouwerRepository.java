package be.vdab.repositories;

import be.vdab.entities.Brouwer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Maarten Westelinck on 6/02/2017 for brouwers.
 */
public interface BrouwerRepository extends JpaRepository<Brouwer, Long>{
    List<Brouwer> findByNaamStartingWith(String naam);
}
