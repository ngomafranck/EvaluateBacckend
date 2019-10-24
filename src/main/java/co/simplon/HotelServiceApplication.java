package co.simplon;

import co.simplon.dao.HotelRepository;
import co.simplon.dao.TownRepository;
import co.simplon.entities.Hotel;
import co.simplon.entities.Town;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Random;

@SpringBootApplication
public class HotelServiceApplication implements CommandLineRunner {
	@Autowired
	private TownRepository townRepository;
	@Autowired
	private HotelRepository hotelRepository;
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) { SpringApplication.run(HotelServiceApplication.class, args);}
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Hotel.class, Town.class);
		townRepository.save(new Town(null,"Paris","Ville lumière",null));
		townRepository.save(new Town(null, "Toulouse",null,null));
		townRepository.save(new Town(null, "Nantes", null,null));
		townRepository.save(new Town(null,"Grenoble", null,null));
		Random rnd=new Random();
		townRepository.findAll().forEach(t->{
			for (int i = 0; i <10 ; i++) {
				Hotel h =new Hotel();
				h.setName(RandomString.make(20));
				h.setDescription(RandomString.make(20));
				h.setPhone(RandomString.make(10));
				h.setAddress(RandomString.make(20));
				h.setStars(RandomString.make(1));
				h.setBedroomavailable(RandomString.make(2));
				h.setPeople(RandomString.make(2));
				h.setPromoted(rnd.nextBoolean());
				h.setSelected(rnd.nextBoolean());
				h.setTown(t);
				h.setPhoto("inconnu.jpeg");
				hotelRepository.save(h);
			}
		});
	}
}

