package co.simplon.dao;

import co.simplon.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface TownRepository extends JpaRepository<Town, Long> {
}

