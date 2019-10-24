package co.simplon.dao;

import co.simplon.entities.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    @RestResource(path = "/byName")
    public List<Hotel> findByNameContains(@Param("mc")String name);
    @RestResource(path = "/ByNamePage")
    public Page<Hotel> findByNameContains(@Param("mc") String name, Pageable pageable);

    @RestResource(path = "/selectedHotels")
    public List<Hotel> findBySelectedIsTrue();
}
