package co.simplon.web;

import co.simplon.dao.HotelRepository;
import co.simplon.entities.Hotel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;

@CrossOrigin("*")
@RestController
public class HotelRestController {
    private HotelRepository hotelRepository;

    public HotelRestController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
    @GetMapping(path="/photoProduct/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Hotel h = hotelRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/hotel-service/hotels/"+h.getPhoto()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
        Hotel h=hotelRepository.findById(id).get();
        h.setPhoto(file.getOriginalFilename());
        Files.write(Paths.get(System.getProperty("user.home")+"/hotel-service/hotels/"+ h.getPhoto()),file.getBytes());
        hotelRepository.save(h);
    }
}
