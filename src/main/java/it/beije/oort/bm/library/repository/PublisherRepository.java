package it.beije.oort.bm.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import it.beije.oort.bm.library.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{


}
