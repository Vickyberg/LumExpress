package africa.volacode.lumexpress.data.models;

import javax.persistence.*;
import java.util.List;
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Item> items;

}
