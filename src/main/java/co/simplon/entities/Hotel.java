package co.simplon.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel implements Serializable {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String description;
   private String phone;
   private String address;
   private String stars;
   private String bedroomavailable;
   private String people;
   private boolean promoted;
   private boolean selected;
   private String photo;
    @ManyToOne
    private  Town town;
}




